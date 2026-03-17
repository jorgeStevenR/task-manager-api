package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.exception.ResourceNotFoundException;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper.RecordatorioMapper;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.messaging.RecordatorioProducer;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.messaging.dto.RecordatorioMessage;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateRecordatorioRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.RecordatorioResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Recordatorio;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Tarea;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.RecordatorioRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.TareaRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.RecordatorioService;

@Service
public class RecordatorioServiceImpl implements RecordatorioService {

    private static final Logger logger = LoggerFactory.getLogger(RecordatorioServiceImpl.class);

    private final RecordatorioRepository recordatorioRepository;
    private final RecordatorioMapper recordatorioMapper;
    private final RecordatorioProducer recordatorioProducer;
    private final TareaRepository tareaRepository;

    public RecordatorioServiceImpl(
            RecordatorioRepository recordatorioRepository,
            RecordatorioMapper recordatorioMapper,
            RecordatorioProducer recordatorioProducer,
            TareaRepository tareaRepository) {

        this.recordatorioRepository = recordatorioRepository;
        this.recordatorioMapper = recordatorioMapper;
        this.recordatorioProducer = recordatorioProducer;
        this.tareaRepository = tareaRepository;
    }

    @Override
    public RecordatorioResponseDTO crearRecordatorio(CreateRecordatorioRequestDTO request) {
        logger.info("Creando nuevo recordatorio para la tarea ID: {}", request.getTareaId());

        Recordatorio recordatorio = recordatorioMapper.toEntity(request);

        Tarea tarea = tareaRepository.findById(request.getTareaId())
                .orElseThrow(() -> {
                    logger.warn("Tarea no encontrada con ID: {}", request.getTareaId());
                    return new ResourceNotFoundException("Tarea no encontrada");
                });

        recordatorio.setTarea(tarea);

        Recordatorio saved = recordatorioRepository.save(recordatorio);

        String email = "sin-email";

        if (tarea.getUsuarioCreador() != null) {
            email = tarea.getUsuarioCreador().getEmail();
        }

        RecordatorioMessage message = new RecordatorioMessage(
                saved.getIdRecordatorio(),
                tarea.getTitulo(),
                email,
                saved.getFechaRecordatorio()
        );

        recordatorioProducer.enviarRecordatorio(message);

        logger.info("Recordatorio creado exitosamente con ID: {}", saved.getIdRecordatorio());
        return recordatorioMapper.toResponse(saved);
    }

    @Override
    public List<RecordatorioResponseDTO> obtenerRecordatoriosPendientes() {
        logger.debug("Obteniendo recordatorios pendientes");

        return recordatorioRepository.findByEnviadoFalse()
                .stream()
                .map(recordatorioMapper::toResponse)
                .collect(Collectors.toList());
    }
}
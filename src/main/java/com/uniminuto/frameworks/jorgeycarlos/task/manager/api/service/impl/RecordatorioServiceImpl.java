package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper.RecordatorioMapper;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateRecordatorioRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.RecordatorioResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Recordatorio;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.RecordatorioRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.RecordatorioService;

@Service
public class RecordatorioServiceImpl implements RecordatorioService {

    private final RecordatorioRepository recordatorioRepository;
    private final RecordatorioMapper recordatorioMapper;

    public RecordatorioServiceImpl(RecordatorioRepository recordatorioRepository,
                                   RecordatorioMapper recordatorioMapper) {

        this.recordatorioRepository = recordatorioRepository;
        this.recordatorioMapper = recordatorioMapper;
    }

    @Override
    public RecordatorioResponseDTO crearRecordatorio(CreateRecordatorioRequestDTO request) {

        Recordatorio recordatorio = recordatorioMapper.toEntity(request);

        Recordatorio saved = recordatorioRepository.save(recordatorio);

        return recordatorioMapper.toResponse(saved);
    }

    @Override
    public List<RecordatorioResponseDTO> obtenerRecordatoriosPendientes() {

        return recordatorioRepository.findByEnviadoFalse()
                .stream()
                .map(recordatorioMapper::toResponse)
                .collect(Collectors.toList());
    }

}
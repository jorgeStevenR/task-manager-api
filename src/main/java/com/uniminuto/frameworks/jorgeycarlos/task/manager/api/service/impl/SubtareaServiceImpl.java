package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.exception.ResourceNotFoundException;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper.SubtareaMapper;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateSubtareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.SubtareaResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Subtarea;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Tarea;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Usuario;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.SubtareaRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.TareaRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.UsuarioRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.SubtareaService;

@Service
public class SubtareaServiceImpl implements SubtareaService {

    private static final Logger logger = LoggerFactory.getLogger(SubtareaServiceImpl.class);

    private final SubtareaRepository subtareaRepository;
    private final SubtareaMapper subtareaMapper;
    private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;

    public SubtareaServiceImpl(
            SubtareaRepository subtareaRepository,
            SubtareaMapper subtareaMapper,
            TareaRepository tareaRepository,
            UsuarioRepository usuarioRepository) {

        this.subtareaRepository = subtareaRepository;
        this.subtareaMapper = subtareaMapper;
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public SubtareaResponseDTO crearSubtarea(CreateSubtareaRequestDTO request) {
        logger.info("Creando nueva subtarea con título: {}", request.getTitulo());

        Subtarea subtarea = subtareaMapper.toEntity(request);

        Tarea tarea = tareaRepository.findById(request.getTareaId())
                .orElseThrow(() -> {
                    logger.warn("Tarea no encontrada con ID: {}", request.getTareaId());
                    return new ResourceNotFoundException("Tarea no encontrada");
                });

        Usuario responsable = usuarioRepository.findById(request.getResponsableId())
                .orElseThrow(() -> {
                    logger.warn("Usuario responsable no encontrado con ID: {}", request.getResponsableId());
                    return new ResourceNotFoundException("Usuario responsable no encontrado");
                });

        subtarea.setTarea(tarea);
        subtarea.setResponsable(responsable);
        subtarea.setFechaCreacion(LocalDateTime.now());

        Subtarea saved = subtareaRepository.save(subtarea);

        logger.info("Subtarea creada exitosamente con ID: {}", saved.getIdSubtarea());
        return subtareaMapper.toResponse(saved);
    }

    @Override
    public List<SubtareaResponseDTO> obtenerSubtareasPorTarea(Long tareaId) {
        logger.debug("Obteniendo subtareas para la tarea ID: {}", tareaId);

        return subtareaRepository.findByTarea_IdTarea(tareaId)
                .stream()
                .map(subtareaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SubtareaResponseDTO completarSubtarea(Long subtareaId) {
        logger.info("Completando subtarea con ID: {}", subtareaId);

        Subtarea subtarea = subtareaRepository.findById(subtareaId)
                .orElseThrow(() -> {
                    logger.warn("Subtarea no encontrada con ID: {}", subtareaId);
                    return new ResourceNotFoundException("Subtarea no encontrada");
                });

        subtarea.setCompletada(true);

        Subtarea updated = subtareaRepository.save(subtarea);

        logger.info("Subtarea completada exitosamente con ID: {}", subtareaId);
        return subtareaMapper.toResponse(updated);
    }
}
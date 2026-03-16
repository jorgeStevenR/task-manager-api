package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.exception.ResourceNotFoundException;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper.SubtareaMapper;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateSubtareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.SubtareaResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Subtarea;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.SubtareaRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.SubtareaService;

@Service
public class SubtareaServiceImpl implements SubtareaService {

    private final SubtareaRepository subtareaRepository;
    private final SubtareaMapper subtareaMapper;

    public SubtareaServiceImpl(SubtareaRepository subtareaRepository,
                               SubtareaMapper subtareaMapper) {
        this.subtareaRepository = subtareaRepository;
        this.subtareaMapper = subtareaMapper;
    }

    @Override
    public SubtareaResponseDTO crearSubtarea(CreateSubtareaRequestDTO request) {

        Subtarea subtarea = subtareaMapper.toEntity(request);

        Subtarea saved = subtareaRepository.save(subtarea);

        return subtareaMapper.toResponse(saved);
    }

    @Override
    public List<SubtareaResponseDTO> obtenerSubtareasPorTarea(Long tareaId) {

        return subtareaRepository.findByTareaIdTarea(tareaId)
                .stream()
                .map(subtareaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SubtareaResponseDTO completarSubtarea(Long subtareaId) {

        Subtarea subtarea = subtareaRepository.findById(subtareaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subtarea no encontrada"));

        subtarea.setCompletada(true);

        Subtarea updated = subtareaRepository.save(subtarea);

        return subtareaMapper.toResponse(updated);
    }

}
package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.exception.ResourceNotFoundException;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper.TareaMapper;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateTareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.TareaResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Tarea;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.TareaRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.TareaService;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;
    private final TareaMapper tareaMapper;

    public TareaServiceImpl(TareaRepository tareaRepository,
                            TareaMapper tareaMapper) {

        this.tareaRepository = tareaRepository;
        this.tareaMapper = tareaMapper;
    }

    @Override
    public TareaResponseDTO crearTarea(CreateTareaRequestDTO request) {

        Tarea tarea = tareaMapper.toEntity(request);

        Tarea saved = tareaRepository.save(tarea);

        return tareaMapper.toResponse(saved);
    }

    @Override
    public TareaResponseDTO obtenerTarea(Long id) {

        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tarea no encontrada"));

        return tareaMapper.toResponse(tarea);
    }

    @Override
    public List<TareaResponseDTO> listarTareas() {

        return tareaRepository.findAll()
                .stream()
                .map(tareaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarTarea(Long id) {

        if (!tareaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tarea no encontrada");
        }

        tareaRepository.deleteById(id);
    }

}
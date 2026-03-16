package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service;

import java.util.List;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateSubtareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.SubtareaResponseDTO;

public interface SubtareaService {

    SubtareaResponseDTO crearSubtarea(CreateSubtareaRequestDTO request);

    List<SubtareaResponseDTO> obtenerSubtareasPorTarea(Long tareaId);

    SubtareaResponseDTO completarSubtarea(Long subtareaId);

}
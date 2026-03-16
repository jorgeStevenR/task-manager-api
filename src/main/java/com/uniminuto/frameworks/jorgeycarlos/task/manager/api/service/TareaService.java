package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service;

import java.util.List;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateTareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.TareaResponseDTO;

public interface TareaService {

    TareaResponseDTO crearTarea(CreateTareaRequestDTO request);

    TareaResponseDTO obtenerTarea(Long id);

    List<TareaResponseDTO> listarTareas();

    void eliminarTarea(Long id);

}
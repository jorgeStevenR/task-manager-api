package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper;

import org.springframework.stereotype.Component;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateTareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.TareaResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Tarea;

@Component
public class TareaMapper {

    public Tarea toEntity(CreateTareaRequestDTO request) {
        Tarea tarea = new Tarea();
        tarea.setTitulo(request.getTitulo());
        tarea.setDescripcion(request.getDescripcion());
        tarea.setPrioridad(request.getPrioridad());
        tarea.setFechaVencimiento(request.getFechaVencimiento());
        return tarea;
    }

    public TareaResponseDTO toResponse(Tarea tarea) {
        return new TareaResponseDTO(
                tarea.getIdTarea(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getPrioridad(),
                tarea.getFechaVencimiento()
        );
    }
}
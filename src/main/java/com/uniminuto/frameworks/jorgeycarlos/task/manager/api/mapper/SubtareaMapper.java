package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper;

import org.springframework.stereotype.Component;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateSubtareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.SubtareaResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Subtarea;

@Component
public class SubtareaMapper {

    public Subtarea toEntity(CreateSubtareaRequestDTO request){

        Subtarea subtarea = new Subtarea();

        subtarea.setTitulo(request.getTitulo());
        subtarea.setCompletada(false);

        return subtarea;
    }

    public SubtareaResponseDTO toResponse(Subtarea subtarea){

        return new SubtareaResponseDTO(
                subtarea.getIdSubtarea(),
                subtarea.getTitulo(),
                subtarea.getCompletada()
        );
    }
}
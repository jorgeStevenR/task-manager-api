package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubtareaResponseDTO {

    private Long idSubtarea;
    private String titulo;
    private Boolean completada;
}
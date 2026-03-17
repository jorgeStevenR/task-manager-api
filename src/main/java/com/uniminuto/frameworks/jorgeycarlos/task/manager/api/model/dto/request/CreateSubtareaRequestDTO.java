package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubtareaRequestDTO {

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 3, max = 200, message = "El título debe tener entre 3 y 200 caracteres")
    private String titulo;

    @NotNull(message = "El ID de la tarea es obligatorio")
    private Long tareaId;

    @NotNull(message = "El ID del responsable es obligatorio")
    private Long responsableId;
}
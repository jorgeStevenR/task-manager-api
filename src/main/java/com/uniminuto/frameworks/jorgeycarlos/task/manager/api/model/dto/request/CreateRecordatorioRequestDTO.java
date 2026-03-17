package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecordatorioRequestDTO {

    @NotNull(message = "La fecha del recordatorio es obligatoria")
    private LocalDateTime fechaRecordatorio;

    @NotBlank(message = "El tipo de notificación es obligatorio")
    private String tipoNotificacion;

    @NotNull(message = "El ID de la tarea es obligatorio")
    private Long tareaId;
}
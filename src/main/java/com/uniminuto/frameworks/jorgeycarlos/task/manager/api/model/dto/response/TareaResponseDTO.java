package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TareaResponseDTO {

    private Long idTarea;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private LocalDateTime fechaVencimiento;
}
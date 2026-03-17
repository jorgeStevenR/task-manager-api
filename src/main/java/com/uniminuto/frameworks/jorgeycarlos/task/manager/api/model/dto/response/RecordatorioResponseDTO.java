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
public class RecordatorioResponseDTO {

    private Long idRecordatorio;
    private LocalDateTime fechaRecordatorio;
    private String tipoNotificacion;
    private Boolean enviado;
    private Long tareaId;
}
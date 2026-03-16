package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request;

import java.time.LocalDateTime;

public class CreateRecordatorioRequestDTO {

    private LocalDateTime fechaRecordatorio;

    private String tipoNotificacion;

    private Long tareaId;

    public LocalDateTime getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public Long getTareaId() {
        return tareaId;
    }
}
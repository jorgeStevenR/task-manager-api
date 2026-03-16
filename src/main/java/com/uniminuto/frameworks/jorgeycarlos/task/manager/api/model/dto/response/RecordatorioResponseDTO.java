package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response;

import java.time.LocalDateTime;

public class RecordatorioResponseDTO {

    private Long idRecordatorio;

    private LocalDateTime fechaRecordatorio;

    private String tipoNotificacion;

    private Boolean enviado;

    private Long tareaId;

    public RecordatorioResponseDTO(Long idRecordatorio,
                                   LocalDateTime fechaRecordatorio,
                                   String tipoNotificacion,
                                   Boolean enviado,
                                   Long tareaId) {

        this.idRecordatorio = idRecordatorio;
        this.fechaRecordatorio = fechaRecordatorio;
        this.tipoNotificacion = tipoNotificacion;
        this.enviado = enviado;
        this.tareaId = tareaId;
    }

    public Long getIdRecordatorio() {
        return idRecordatorio;
    }

    public LocalDateTime getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public Long getTareaId() {
        return tareaId;
    }
}
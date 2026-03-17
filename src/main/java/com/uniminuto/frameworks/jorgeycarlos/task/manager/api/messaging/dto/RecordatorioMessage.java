package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.messaging.dto;


import java.time.LocalDateTime;
import java.io.Serializable;

public class RecordatorioMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long recordatorioId;
    private String tituloTarea;
    private String emailUsuario;
    private LocalDateTime fechaRecordatorio;

    public RecordatorioMessage() {}

    public RecordatorioMessage(Long recordatorioId,
                               String tituloTarea,
                               String emailUsuario,
                               LocalDateTime fechaRecordatorio) {

        this.recordatorioId = recordatorioId;
        this.tituloTarea = tituloTarea;
        this.emailUsuario = emailUsuario;
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public Long getRecordatorioId() {
        return recordatorioId;
    }

    public String getTituloTarea() {
        return tituloTarea;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public LocalDateTime getFechaRecordatorio() {
        return fechaRecordatorio;
    }
}
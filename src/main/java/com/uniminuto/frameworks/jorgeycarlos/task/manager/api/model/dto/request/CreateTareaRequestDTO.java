package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request;

import java.time.LocalDateTime;

public class CreateTareaRequestDTO {

    private String titulo;

    private String descripcion;

    private LocalDateTime fechaVencimiento;

    private String prioridad;

    private Long usuarioCreadorId;

    private Long categoriaId;

    private Long estadoId;

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public Long getUsuarioCreadorId() {
        return usuarioCreadorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getEstadoId() {
        return estadoId;
    }
}
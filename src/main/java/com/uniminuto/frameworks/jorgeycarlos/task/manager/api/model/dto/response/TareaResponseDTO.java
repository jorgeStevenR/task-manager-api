package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response;

import java.time.LocalDateTime;

public class TareaResponseDTO {

    private Long idTarea;

    private String titulo;

    private String descripcion;

    private String prioridad;

    private LocalDateTime fechaVencimiento;

    public TareaResponseDTO(Long idTarea,
                            String titulo,
                            String descripcion,
                            String prioridad,
                            LocalDateTime fechaVencimiento) {

        this.idTarea = idTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }
}
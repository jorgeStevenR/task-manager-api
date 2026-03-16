package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request;

public class CreateSubtareaRequestDTO {

    private String titulo;

    private Long tareaId;

    private Long responsableId;

    public String getTitulo() {
        return titulo;
    }

    public Long getTareaId() {
        return tareaId;
    }

    public Long getResponsableId() {
        return responsableId;
    }
}
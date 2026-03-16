package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response;

public class SubtareaResponseDTO {

    private Long idSubtarea;

    private String titulo;

    private Boolean completada;

    public SubtareaResponseDTO(Long idSubtarea, String titulo, Boolean completada) {
        this.idSubtarea = idSubtarea;
        this.titulo = titulo;
        this.completada = completada;
    }

    public Long getIdSubtarea() {
        return idSubtarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public Boolean getCompletada() {
        return completada;
    }
}
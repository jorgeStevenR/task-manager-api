package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response;

public class UsuarioResponseDTO {

    private Long idUsuario;

    private String nombre;

    private String email;

    private String telefono;

    public UsuarioResponseDTO(Long idUsuario, String nombre, String email, String telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
}
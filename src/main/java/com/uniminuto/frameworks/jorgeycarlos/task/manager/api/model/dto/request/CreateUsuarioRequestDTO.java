package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request;

public class CreateUsuarioRequestDTO {

    private String nombre;

    private String email;

    private String telefono;

    private String password;

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPassword() {
        return password;
    }
}
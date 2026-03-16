package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service;

import java.util.List;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateUsuarioRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.UsuarioResponseDTO;

public interface UsuarioService {

    UsuarioResponseDTO crearUsuario(CreateUsuarioRequestDTO request);

    UsuarioResponseDTO obtenerUsuario(Long id);

    List<UsuarioResponseDTO> listarUsuarios();

    void eliminarUsuario(Long id);

}
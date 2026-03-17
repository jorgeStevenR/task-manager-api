package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateUsuarioRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.UsuarioResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Usuario;

@Component
public class UsuarioMapper {

    public Usuario toEntity(CreateUsuarioRequestDTO request) {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());
        usuario.setTelefono(request.getTelefono());
        usuario.setPassword(request.getPassword());
        usuario.setFechaCreacion(LocalDateTime.now());
        return usuario;
    }

    public UsuarioResponseDTO toResponse(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getTelefono()
        );
    }
}
package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.exception.ResourceNotFoundException;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper.UsuarioMapper;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateUsuarioRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.UsuarioResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Usuario;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.UsuarioRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioResponseDTO crearUsuario(CreateUsuarioRequestDTO request) {
        logger.info("Creando nuevo usuario con email: {}", request.getEmail());

        Usuario usuario = usuarioMapper.toEntity(request);
        Usuario saved = usuarioRepository.save(usuario);

        logger.info("Usuario creado exitosamente con ID: {}", saved.getIdUsuario());
        return usuarioMapper.toResponse(saved);
    }

    @Override
    public UsuarioResponseDTO obtenerUsuario(Long id) {
        logger.debug("Obteniendo usuario con ID: {}", id);

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Usuario no encontrado con ID: {}", id);
                    return new ResourceNotFoundException("Usuario no encontrado");
                });

        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> listarUsuarios() {
        logger.debug("Listando todos los usuarios");

        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarUsuario(Long id) {
        logger.info("Eliminando usuario con ID: {}", id);

        if (!usuarioRepository.existsById(id)) {
            logger.warn("Intento de eliminar usuario que no existe con ID: {}", id);
            throw new ResourceNotFoundException("Usuario no encontrado");
        }

        usuarioRepository.deleteById(id);
        logger.info("Usuario eliminado exitosamente con ID: {}", id);
    }
}
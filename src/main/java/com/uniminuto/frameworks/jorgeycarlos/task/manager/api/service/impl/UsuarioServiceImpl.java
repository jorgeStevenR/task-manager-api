package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioResponseDTO crearUsuario(CreateUsuarioRequestDTO request) {

        Usuario usuario = usuarioMapper.toEntity(request);

        Usuario saved = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(saved);
    }

    @Override
    public UsuarioResponseDTO obtenerUsuario(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario no encontrado"));

        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> listarUsuarios() {

        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarUsuario(Long id) {

        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado");
        }

        usuarioRepository.deleteById(id);
    }

}
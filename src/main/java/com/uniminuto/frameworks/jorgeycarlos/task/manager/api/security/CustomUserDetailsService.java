package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.UsuarioRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Usuario;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
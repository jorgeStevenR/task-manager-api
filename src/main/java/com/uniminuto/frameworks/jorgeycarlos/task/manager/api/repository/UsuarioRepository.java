package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}

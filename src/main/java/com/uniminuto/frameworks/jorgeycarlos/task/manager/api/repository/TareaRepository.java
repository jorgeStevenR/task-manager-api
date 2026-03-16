package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByUsuarioCreadorIdUsuario(Long idUsuario);

}

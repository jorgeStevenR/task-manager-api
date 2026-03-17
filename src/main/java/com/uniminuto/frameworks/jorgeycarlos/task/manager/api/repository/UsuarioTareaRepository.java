package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.UsuarioTarea;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.UsuarioTareaId;

public interface UsuarioTareaRepository extends JpaRepository<UsuarioTarea, UsuarioTareaId> {
    List<UsuarioTarea> findByUsuario_IdUsuario(Long idUsuario);
    List<UsuarioTarea> findByTarea_IdTarea(Long idTarea);
}

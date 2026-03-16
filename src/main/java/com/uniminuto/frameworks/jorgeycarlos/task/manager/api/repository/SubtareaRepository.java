package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Subtarea;

public interface SubtareaRepository extends JpaRepository<Subtarea, Long> {
    List<Subtarea> findByTareaIdTarea(Long tareaId);

}

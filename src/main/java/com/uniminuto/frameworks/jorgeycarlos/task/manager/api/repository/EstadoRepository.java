package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
}

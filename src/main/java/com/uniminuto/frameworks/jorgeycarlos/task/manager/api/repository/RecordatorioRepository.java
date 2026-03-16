package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Recordatorio;

public interface RecordatorioRepository extends JpaRepository<Recordatorio, Long> {
    List<Recordatorio> findByEnviadoFalse();
}

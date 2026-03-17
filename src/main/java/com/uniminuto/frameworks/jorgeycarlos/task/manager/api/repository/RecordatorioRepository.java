package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Recordatorio;

public interface RecordatorioRepository extends JpaRepository<Recordatorio, Long> {

    @Query("""
        SELECT r
        FROM Recordatorio r
        JOIN FETCH r.tarea t
        JOIN FETCH t.usuarioCreador
        WHERE r.enviado = false
    """)
    List<Recordatorio> findByEnviadoFalse();

}
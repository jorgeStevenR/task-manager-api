package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Recordatorio;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.RecordatorioRepository;

@Component
public class RecordatorioScheduler {

    private final RecordatorioRepository recordatorioRepository;

    public RecordatorioScheduler(RecordatorioRepository recordatorioRepository) {
        this.recordatorioRepository = recordatorioRepository;
    }

    @Scheduled(fixedRate = 60000) // cada minuto
    public void verificarRecordatorios(){

        List<Recordatorio> pendientes =
                recordatorioRepository.findByEnviadoFalse();

        LocalDateTime ahora = LocalDateTime.now();

        for (Recordatorio recordatorio : pendientes) {

            if(recordatorio.getFechaRecordatorio().isBefore(ahora)
               || recordatorio.getFechaRecordatorio().isEqual(ahora)){

                System.out.println("Enviar recordatorio para tarea: "
                        + recordatorio.getTarea().getTitulo());

                recordatorio.setEnviado(true);

                recordatorioRepository.save(recordatorio);
            }
        }

    }

}
package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.scheduler;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.messaging.RecordatorioProducer;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.messaging.dto.RecordatorioMessage;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Recordatorio;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.RecordatorioRepository;

@Component
public class RecordatorioScheduler {

    private static final Logger logger = LoggerFactory.getLogger(RecordatorioScheduler.class);

    private final RecordatorioRepository recordatorioRepository;
    private final RecordatorioProducer producer;

    public RecordatorioScheduler(
            RecordatorioRepository recordatorioRepository,
            RecordatorioProducer producer) {

        this.recordatorioRepository = recordatorioRepository;
        this.producer = producer;
    }

    @Scheduled(fixedRate = 60000)
    public void verificarRecordatorios() {
        logger.info("Iniciando verificación de recordatorios pendientes");

        try {
            List<Recordatorio> pendientes = recordatorioRepository.findByEnviadoFalse();
            LocalDateTime ahora = LocalDateTime.now();

            logger.debug("Se encontraron {} recordatorios pendientes", pendientes.size());

            for (Recordatorio recordatorio : pendientes) {
                if (recordatorio.getFechaRecordatorio() != null &&
                    (recordatorio.getFechaRecordatorio().isBefore(ahora) ||
                     recordatorio.getFechaRecordatorio().isEqual(ahora))) {

                    try {
                        if (recordatorio.getTarea() == null ||
                            recordatorio.getTarea().getUsuarioCreador() == null) {
                            logger.warn("Recordatorio {} sin tarea o usuario asociado", recordatorio.getIdRecordatorio());
                            continue;
                        }

                        RecordatorioMessage message = new RecordatorioMessage(
                                recordatorio.getIdRecordatorio(),
                                recordatorio.getTarea().getTitulo(),
                                recordatorio.getTarea().getUsuarioCreador().getEmail(),
                                recordatorio.getFechaRecordatorio()
                        );

                        producer.enviarRecordatorio(message);
                        recordatorio.setEnviado(true);
                        recordatorioRepository.save(recordatorio);

                        logger.info("Recordatorio {} enviado exitosamente", recordatorio.getIdRecordatorio());
                    } catch (Exception e) {
                        logger.error("Error procesando recordatorio {}: {}", recordatorio.getIdRecordatorio(), e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error en el scheduler de recordatorios: {}", e.getMessage(), e);
        }
    }
}
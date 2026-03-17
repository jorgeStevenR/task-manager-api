package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.config.RabbitMQConfig;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.messaging.dto.RecordatorioMessage;

@Component
public class RecordatorioConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RecordatorioConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumirRecordatorio(RecordatorioMessage message) {
        try {
            logger.info("Recordatorio recibido - Tarea: {}, Email: {}, Fecha: {}",
                    message.getTituloTarea(),
                    message.getEmailUsuario(),
                    message.getFechaRecordatorio());

            // Aquí irá la lógica actual de envío de notificaciones
            // Por ahora solo se registra en el log

        } catch (Exception e) {
            logger.error("Error procesando recordatorio: {}", e.getMessage(), e);
        }
    }
}
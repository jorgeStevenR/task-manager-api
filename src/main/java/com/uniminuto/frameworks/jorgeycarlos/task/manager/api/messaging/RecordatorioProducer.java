package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.config.RabbitMQConfig;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.messaging.dto.RecordatorioMessage;

@Component
public class RecordatorioProducer {

    private static final Logger logger = LoggerFactory.getLogger(RecordatorioProducer.class);
    private final RabbitTemplate rabbitTemplate;

    public RecordatorioProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarRecordatorio(RecordatorioMessage message) {
        try {
            rabbitTemplate.convertAndSend(
                    RabbitMQConfig.EXCHANGE,
                    RabbitMQConfig.ROUTING_KEY,
                    message
            );
            logger.info("Recordatorio enviado a la cola - ID: {}, Email: {}",
                    message.getRecordatorioId(),
                    message.getEmailUsuario());
        } catch (Exception e) {
            logger.error("Error enviando recordatorio a RabbitMQ: {}", e.getMessage(), e);
            throw new RuntimeException("Error al enviar recordatorio a la cola", e);
        }
    }
}
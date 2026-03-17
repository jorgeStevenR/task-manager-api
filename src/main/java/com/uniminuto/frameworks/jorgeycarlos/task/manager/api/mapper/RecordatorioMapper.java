package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper;

import org.springframework.stereotype.Component;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateRecordatorioRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.RecordatorioResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Recordatorio;

@Component
public class RecordatorioMapper {

    public Recordatorio toEntity(CreateRecordatorioRequestDTO request) {
        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setFechaRecordatorio(request.getFechaRecordatorio());
        recordatorio.setTipoNotificacion(request.getTipoNotificacion());
        recordatorio.setEnviado(false);
        return recordatorio;
    }

    public RecordatorioResponseDTO toResponse(Recordatorio recordatorio) {
        Long tareaId = null;

        if (recordatorio.getTarea() != null) {
            tareaId = recordatorio.getTarea().getIdTarea();
        }

        return new RecordatorioResponseDTO(
                recordatorio.getIdRecordatorio(),
                recordatorio.getFechaRecordatorio(),
                recordatorio.getTipoNotificacion(),
                recordatorio.getEnviado(),
                tareaId
        );
    }
}
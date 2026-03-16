package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service;

import java.util.List;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateRecordatorioRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.RecordatorioResponseDTO;

public interface RecordatorioService {

    RecordatorioResponseDTO crearRecordatorio(CreateRecordatorioRequestDTO request);

    List<RecordatorioResponseDTO> obtenerRecordatoriosPendientes();

}
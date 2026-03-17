package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateRecordatorioRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.RecordatorioResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.RecordatorioService;

@RestController
@RequestMapping("/recordatorios")
public class RecordatorioController {

    private final RecordatorioService recordatorioService;

    public RecordatorioController(RecordatorioService recordatorioService) {
        this.recordatorioService = recordatorioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecordatorioResponseDTO crearRecordatorio(@Valid @RequestBody CreateRecordatorioRequestDTO request) {
        return recordatorioService.crearRecordatorio(request);
    }

    @GetMapping("/pendientes")
    @ResponseStatus(HttpStatus.OK)
    public List<RecordatorioResponseDTO> obtenerRecordatoriosPendientes() {
        return recordatorioService.obtenerRecordatoriosPendientes();
    }
}
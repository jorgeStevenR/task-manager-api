package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateSubtareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.SubtareaResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.SubtareaService;

@RestController
@RequestMapping("/api/subtareas")
public class SubtareaController {

    private final SubtareaService subtareaService;

    public SubtareaController(SubtareaService subtareaService) {
        this.subtareaService = subtareaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubtareaResponseDTO crearSubtarea(
            @RequestBody CreateSubtareaRequestDTO request){

        return subtareaService.crearSubtarea(request);
    }

    @GetMapping("/tarea/{tareaId}")
    @ResponseStatus(HttpStatus.OK)
    public List<SubtareaResponseDTO> obtenerSubtareasPorTarea(
            @PathVariable Long tareaId){

        return subtareaService.obtenerSubtareasPorTarea(tareaId);
    }

    @PatchMapping("/{id}/completar")
    @ResponseStatus(HttpStatus.OK)
    public SubtareaResponseDTO completarSubtarea(
            @PathVariable Long id){

        return subtareaService.completarSubtarea(id);
    }

}
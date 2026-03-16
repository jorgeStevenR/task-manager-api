package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateTareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.TareaResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.TareaService;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TareaResponseDTO crearTarea(
            @RequestBody CreateTareaRequestDTO request){

        return tareaService.crearTarea(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TareaResponseDTO obtenerTarea(@PathVariable Long id){

        return tareaService.obtenerTarea(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TareaResponseDTO> listarTareas(){

        return tareaService.listarTareas();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarTarea(@PathVariable Long id){

        tareaService.eliminarTarea(id);
    }

}
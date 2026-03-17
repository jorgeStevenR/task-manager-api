package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.exception.ResourceNotFoundException;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.mapper.TareaMapper;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.CreateTareaRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.TareaResponseDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Categoria;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Estado;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Tarea;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity.Usuario;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.CategoriaRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.EstadoRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.TareaRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.repository.UsuarioRepository;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service.TareaService;

@Service
public class TareaServiceImpl implements TareaService {

    private static final Logger logger = LoggerFactory.getLogger(TareaServiceImpl.class);

    private final TareaRepository tareaRepository;
    private final TareaMapper tareaMapper;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;
    private final EstadoRepository estadoRepository;

    public TareaServiceImpl(
            TareaRepository tareaRepository,
            TareaMapper tareaMapper,
            UsuarioRepository usuarioRepository,
            CategoriaRepository categoriaRepository,
            EstadoRepository estadoRepository) {

        this.tareaRepository = tareaRepository;
        this.tareaMapper = tareaMapper;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public TareaResponseDTO crearTarea(CreateTareaRequestDTO request) {
        logger.info("Creando nueva tarea con título: {}", request.getTitulo());

        Tarea tarea = tareaMapper.toEntity(request);

        Usuario usuario = usuarioRepository.findById(request.getUsuarioCreadorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario no encontrado"));

        Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria no encontrada"));

        Estado estado = estadoRepository.findById(request.getEstadoId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Estado no encontrado"));

        tarea.setUsuarioCreador(usuario);
        tarea.setCategoria(categoria);
        tarea.setEstado(estado);
        tarea.setFechaCreacion(LocalDateTime.now());

        Tarea saved = tareaRepository.save(tarea);
        logger.info("Tarea creada exitosamente con ID: {}", saved.getIdTarea());

        return tareaMapper.toResponse(saved);
    }

    @Override
    public TareaResponseDTO obtenerTarea(Long id) {
        logger.debug("Obteniendo tarea con ID: {}", id);

        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Tarea no encontrada con ID: {}", id);
                    return new ResourceNotFoundException("Tarea no encontrada");
                });

        return tareaMapper.toResponse(tarea);
    }

    @Override
    public List<TareaResponseDTO> listarTareas() {
        logger.debug("Listando todas las tareas");

        return tareaRepository.findAll()
                .stream()
                .map(tareaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarTarea(Long id) {
        logger.info("Eliminando tarea con ID: {}", id);

        if (!tareaRepository.existsById(id)) {
            logger.warn("Intento de eliminar tarea que no existe con ID: {}", id);
            throw new ResourceNotFoundException("Tarea no encontrada");
        }

        tareaRepository.deleteById(id);
        logger.info("Tarea eliminada exitosamente con ID: {}", id);
    }
}
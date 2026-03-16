package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario_tarea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioTarea {

    @EmbeddedId
    private UsuarioTareaId id;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @MapsId("tareaId")
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    private String rol;

}
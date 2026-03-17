package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tareaId")
    @JoinColumn(name = "tarea_id")
    @JsonIgnore
    private Tarea tarea;

    private String rol;

}
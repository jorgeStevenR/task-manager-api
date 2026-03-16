package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "subtarea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subtarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubtarea;

    private String titulo;

    private Boolean completada;

    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Usuario responsable;

}
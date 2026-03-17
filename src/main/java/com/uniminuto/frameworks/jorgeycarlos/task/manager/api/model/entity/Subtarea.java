package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarea_id")
    @JsonIgnore
    private Tarea tarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsable_id")
    @JsonIgnore
    private Usuario responsable;

}
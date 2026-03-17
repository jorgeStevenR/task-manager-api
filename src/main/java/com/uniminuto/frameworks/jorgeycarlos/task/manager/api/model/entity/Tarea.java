package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tarea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarea;

    private String titulo;

    private String descripcion;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaVencimiento;

    private String prioridad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_creador")
    private Usuario usuarioCreador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @JsonIgnore
    @OneToMany(mappedBy = "tarea", fetch = FetchType.LAZY)
    private List<Subtarea> subtareas;

    @JsonIgnore
    @OneToMany(mappedBy = "tarea", fetch = FetchType.LAZY)
    private List<Recordatorio> recordatorios;

}
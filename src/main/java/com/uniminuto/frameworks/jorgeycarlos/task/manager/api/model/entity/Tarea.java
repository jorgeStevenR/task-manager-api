package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "usuario_creador")
    private Usuario usuarioCreador;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @OneToMany(mappedBy = "tarea")
    private List<Subtarea> subtareas;

    @OneToMany(mappedBy = "tarea")
    private List<Recordatorio> recordatorios;

}
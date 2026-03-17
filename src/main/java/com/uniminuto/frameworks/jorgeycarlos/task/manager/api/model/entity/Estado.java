package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private List<Tarea> tareas;

}
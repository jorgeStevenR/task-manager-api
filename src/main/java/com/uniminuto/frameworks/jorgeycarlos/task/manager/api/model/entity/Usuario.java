package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;

    private String email;

    private String telefono;

    private String password;

    private LocalDateTime fechaCreacion;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioCreador", fetch = FetchType.LAZY)
    private List<Tarea> tareasCreadas;

}
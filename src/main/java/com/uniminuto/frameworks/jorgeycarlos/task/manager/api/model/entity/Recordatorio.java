package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recordatorio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recordatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecordatorio;

    private LocalDateTime fechaRecordatorio;

    private String tipoNotificacion;

    private Boolean enviado;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

}
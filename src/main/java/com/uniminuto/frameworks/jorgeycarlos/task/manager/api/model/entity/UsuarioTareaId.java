package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioTareaId implements Serializable {

    private Long usuarioId;

    private Long tareaId;

}
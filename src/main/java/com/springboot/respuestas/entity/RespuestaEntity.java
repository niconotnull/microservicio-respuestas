package com.springboot.respuestas.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "respuestas")
@Getter
@Setter
@ToString
public class RespuestaEntity {

    @Id
    private String id;

    private String texto;

//    @Transient
    private AlumnoEntity alumno;

    private Integer alumnoId;

//    @Transient
    private PreguntaEntity pregunta;

    private Integer preguntaId;
}

package com.springboot.respuestas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;


@Getter
@Setter
public class AlumnoEntity {


    private Integer id;


    private String nombre;


    private String apellido;


    private String email;


    private Date createAt;

    @JsonIgnore
    private byte[] foto;



    public Integer getFotoHashCode(){
        return (this.foto != null) ? Arrays.hashCode(this.foto) : null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AlumnoEntity)) {
            return false;
        }

        AlumnoEntity a = (AlumnoEntity) obj;

        return this.id != null && this.id.equals(a.getId());
    }
}

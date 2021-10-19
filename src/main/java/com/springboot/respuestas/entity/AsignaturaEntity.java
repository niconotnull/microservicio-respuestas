package com.springboot.respuestas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "asignaturas")
//@Getter
//@Setter
public class AsignaturaEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "nombre")
    private String nombre;

    @JsonIgnoreProperties(value={"hijos","handler", "hibernateLazyInitializer"})
//    @ManyToOne(fetch = FetchType.LAZY)
    private AsignaturaEntity padre;

    @JsonIgnoreProperties(value={"padre","handler", "hibernateLazyInitializer"}, allowSetters = true)
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre", cascade = CascadeType.ALL)
    private List<AsignaturaEntity> hijos;

    public AsignaturaEntity(){
        this.hijos = new ArrayList<>();
    }
}


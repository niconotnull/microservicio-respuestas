package com.springboot.respuestas.entity;

import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class ExamenEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty
    private  String nombre;

//    @Column(name = "create_at")
    private Date createAt;

//    @JsonIgnoreProperties(value = {"examen", "handler", "hibernateLazyInitializer"}, allowSetters = true)
//    @OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PreguntaEntity> preguntas;

//    @NotNull
//    @ManyToOne(fetch = FetchType.EAGER)
//    private  AsignaturaEntity asignatura;

//    @Transient
    private boolean respondido;

//    @PrePersist
    public  void prePersist(){
        this.createAt = new Date();
    }

    public ExamenEntity() {
        this.preguntas = new ArrayList<>();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setPreguntas(List<PreguntaEntity> preguntas) {
        this.preguntas.clear();
        preguntas.forEach(this::addPregunta);
    }

    public void addPregunta(PreguntaEntity pregunta){
        this.preguntas.add(pregunta);
        pregunta.setExamen(this);
    }

    public void removePregunta(PreguntaEntity pregunta){
        this.preguntas.remove(pregunta);
        pregunta.setExamen(null);
    }

}

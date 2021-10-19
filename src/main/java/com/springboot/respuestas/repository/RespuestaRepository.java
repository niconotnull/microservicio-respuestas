package com.springboot.respuestas.repository;

import com.springboot.respuestas.entity.RespuestaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RespuestaRepository extends MongoRepository<RespuestaEntity, String> {

    @Query("{'alumnoId': ?0, 'preguntaId': { $in: ?1 } }")
    List<RespuestaEntity> findRepuestaByAlumnoByPreguntaIds(Integer alumnoId, Iterable<Integer> preguntaIds);

    @Query("{'alumnoId': ?0}")
    List<RespuestaEntity> findByAlumnoId(Integer alumnoId);

//    @Query("select r from RespuestaEntity r  join fetch r.pregunta p join fetch p.examen e where r.alumnoId=?1 and e.id=?2")
//    public List<RespuestaEntity> findRepuestaByAlumnoByExamen(Integer alumnoId, Integer examendId);

//    @Query("select e.id from RespuestaEntity r   join r.pregunta p join p.examen e where r.alumnoId=?1 group by e.id")
//    public Iterable<Integer> findExamenesIdsConRespuestasByAlumno(Integer id);

    @Query("{'alumnoId': ?0, 'pregunta.examen.id': ?1}")
     List<RespuestaEntity> findRepuestaByAlumnoByExamen(Integer alumnoId, Integer examendId);

    @Query( value = "{'alumnoId': ?0}", fields = "{'pregunta.examen.id':1}")
    List<RespuestaEntity> findExamenesIdsConRespuestasByAlumno(Integer alumnoId);

}

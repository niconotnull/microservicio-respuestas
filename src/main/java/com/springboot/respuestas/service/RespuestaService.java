package com.springboot.respuestas.service;

import com.springboot.respuestas.entity.RespuestaEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RespuestaService {

    List<RespuestaEntity> saveAll(List<RespuestaEntity> respuestas);

    List<RespuestaEntity> findRepuestaByAlumnoByExamen(Integer alumnoId, Integer examendId);

    Iterable<Integer> findExamenesIdsConRespuestasByAlumno(Integer id);

    List<RespuestaEntity> findByAlumnoId(Integer alumnoId);


}

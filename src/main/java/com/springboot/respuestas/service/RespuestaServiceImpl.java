package com.springboot.respuestas.service;

import com.springboot.respuestas.client.ExamenFeignClient;
import com.springboot.respuestas.entity.ExamenEntity;
import com.springboot.respuestas.entity.PreguntaEntity;
import com.springboot.respuestas.entity.RespuestaEntity;
import com.springboot.respuestas.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaServiceImpl implements  RespuestaService{

    @Autowired
    private ExamenFeignClient examenClient;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Override
    public List<RespuestaEntity> saveAll(List<RespuestaEntity> respuestas) {
        return (List<RespuestaEntity>) respuestaRepository.saveAll(respuestas);
    }

    @Override
    public List<RespuestaEntity> findRepuestaByAlumnoByExamen(Integer alumnoId, Integer examendId) {
       /* ExamenEntity examen = examenClient.obtenerExamenPorId(examendId);
        List<PreguntaEntity> preguntas = examen.getPreguntas();
        List<Integer> preguntaIds = preguntas.stream().map(p -> p.getId()).collect(Collectors.toList());
        List<RespuestaEntity> respuestas = (List<RespuestaEntity>) respuestaRepository.findRepuestaByAlumnoByPreguntaIds(alumnoId, preguntaIds);
        respuestas = respuestas.stream().map(r ->{
            preguntas.forEach(p ->{
                if(p.getId() == r.getPreguntaId()) {
                    r.setPregunta(p);
                }
            });
            return r;
        }).collect(Collectors.toList());
*/
        List<RespuestaEntity> respuestas = (List<RespuestaEntity>) respuestaRepository.findRepuestaByAlumnoByExamen(alumnoId, examendId);

        return respuestas;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Integer> findExamenesIdsConRespuestasByAlumno(Integer id) {
//        List<RespuestaEntity> respuestasAlumno = respuestaRepository.findByAlumnoId(id);
//        List<Integer> examenIds = Collections.emptyList();
//
//        if(respuestasAlumno.size() > 0) {
//            List<Integer> preguntaIds = respuestasAlumno.stream().map(r -> r.getPreguntaId()).collect(Collectors.toList());
//            examenIds = examenClient.obtenerExamenesIdsPorPreguntasIdsRespondidas(preguntaIds);
//        }
        List<RespuestaEntity> respuestasAlumno = respuestaRepository.findExamenesIdsConRespuestasByAlumno(id);

        return respuestasAlumno.stream().map(r-> r.getPregunta().getExamen().getId()).distinct().collect(Collectors.toList());
    }

    @Override
    public List<RespuestaEntity> findByAlumnoId(Integer alumnoId) {
        return respuestaRepository.findByAlumnoId(alumnoId);
    }
}

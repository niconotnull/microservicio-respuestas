package com.springboot.respuestas.client;

import com.springboot.respuestas.entity.ExamenEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "microservicio-examenes")
public interface ExamenFeignClient {

    @GetMapping(value = "/{id}")
    ExamenEntity obtenerExamenPorId(@PathVariable Integer id);


    @GetMapping(value = "/respondidos-por-preguntas/")
    List<Integer>obtenerExamenesIdsPorPreguntasIdsRespondidas(@RequestParam List<Integer> preguntaIds);
}

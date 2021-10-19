package com.springboot.respuestas.controller;

import com.springboot.respuestas.entity.RespuestaEntity;
import com.springboot.respuestas.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping()
    public ResponseEntity<?> crear(@RequestBody List<RespuestaEntity> respuestas) {
        try {
            respuestas = respuestas.stream().map(r->{
                r.setAlumnoId(r.getAlumno().getId());
                r.setPreguntaId(r.getPregunta().getId());
                return r;
            }).collect(Collectors.toList());

            return new ResponseEntity<>(respuestaService.saveAll(respuestas), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/alumno/{alumnoId}/examen/{examenId}")
    public ResponseEntity<?> obtenerRepustasPorAlumnoPorExamen(@PathVariable Integer alumnoId , @PathVariable Integer examenId){
        try {
            List<RespuestaEntity> as = respuestaService.findRepuestaByAlumnoByExamen(alumnoId,examenId);
            return new ResponseEntity<>(as, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/alumno/{alumnoId}/examenes-respondidos")
    public ResponseEntity<?> obtenerExamenesIdsConRespuestasAlumno(@PathVariable Integer alumnoId){
        try {
            return new ResponseEntity<>(respuestaService.findExamenesIdsConRespuestasByAlumno(alumnoId), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }



}

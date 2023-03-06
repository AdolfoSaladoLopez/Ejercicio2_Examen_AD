package com.example.ejercicio2examen.controllers;

import com.example.ejercicio2examen.models.Alumno;
import com.example.ejercicio2examen.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alumnado")
public class AlumnoController {

    @Autowired
    AlumnoRepository repo;

    @GetMapping()
    public List<Alumno> getAlumnos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getById(@PathVariable Long id) {
        if (repo.existsById(id)) {
            return new ResponseEntity<>(repo.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/suspensos/{modulo}")
    public ResponseEntity<List<Alumno>> getSuspensos(@PathVariable String modulo) {
        if (modulo.equals("ad")) {
            return new ResponseEntity<>(repo.getAllByAdIsLessThan(5.0), HttpStatus.OK);
        } else if (modulo.equals("di")) {
            return new ResponseEntity<>(repo.getAllByDiLessThan(5.0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
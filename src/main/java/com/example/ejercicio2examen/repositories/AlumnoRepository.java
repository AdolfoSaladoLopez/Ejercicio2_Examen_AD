package com.example.ejercicio2examen.repositories;

import com.example.ejercicio2examen.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    List<Alumno> getAllByAdIsLessThan(Double media);

    List<Alumno> getAllByDiLessThan(Double media);
}

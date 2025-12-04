package com.etapa1.Personas;

import java.util.List;

public class Profesor {
    private String nombre;
    private List<Alumno> alumnos;

    public Profesor(String nombre, List<Alumno> alumnos) {
        this.nombre = nombre;
        this.alumnos = alumnos;
    }

    public String getNombre() {
        return nombre;
    }
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
}

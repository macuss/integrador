package com.etapa1.Personas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.etapa1.Numeros.Project;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        // prueba clase Project
        Project p = new Project("Proyecto1", 5000, "abc123token");
        System.out.println("Nombre del proyecto: " + p.getTimeOutMs());

        // prueba clase Alumno
        Alumno alu = new Alumno("Maxi Schultz", 12345);
        Alumno alu2 = new Alumno("Juan Perez", 67890);
        System.out.println("Nombre del alumno: " + alu.getNombre() + ", Legajo: " + alu.getLegajo());

        List<Alumno> alumnos = Arrays.asList(alu, alu2);
        Profesor profe = new Profesor("Neurus", alumnos);  
        System.out.println("Nombre del profesor: " + profe.getNombre() + ", Cantidad de alumnos: " + profe.getAlumnos().size());

        System.out.println("Lista de alumnos del profesor:");
        profe.getAlumnos().forEach(a -> {
            System.out.println("Alumno: " + a.getNombre() + ", Legajo: " + a.getLegajo());
        });


    }
}

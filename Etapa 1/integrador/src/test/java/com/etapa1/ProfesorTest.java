package com.etapa1;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

import org.junit.jupiter.api.Test;

import com.etapa1.Personas.Alumno;
import com.etapa1.Personas.Profesor;

public class ProfesorTest {

    @Test
    public void testProfesorCreation() {
        Alumno alu1 = new Alumno("Ana Gomez", 11111);
        Alumno alu2 = new Alumno("Luis Martinez", 22222);
        //List<Alumno> alumnos = Arrays.asList(alu1, alu2);
        Profesor profe = new Profesor("Dr. Smith", List.of(alu1, alu2));

        assertEquals(profe.getNombre(), "Dr. Smith");
        assert profe.getAlumnos().size() == 2;
        assert profe.getAlumnos().get(0).getNombre().equals("Ana Gomez");
        assert profe.getAlumnos().get(1).getLegajo() == 22222;
    }

}

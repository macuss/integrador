package com.etapa1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.etapa1.Personas.Alumno;

public class AlumnoTest {

    @Test
    public void testAlumno() {
        Alumno a = new Alumno("Juan Perez", 12345);
        assertEquals("Juan Perez", a.getNombre());
        assertEquals(12345, a.getLegajo());
    }

}

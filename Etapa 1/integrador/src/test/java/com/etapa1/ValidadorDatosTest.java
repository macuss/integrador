package com.etapa1;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.etapa1.Personas.Persona;
import com.etapa1.Personas.ValidadorDatos;

class validadorDatosTest {


    @Test
    void testProcesarLineas() {

        // lista hardcodeada para no tener que leer desde un archivo de texto
        List<String> lineas = Arrays.asList(
            "juan,22",
            "maxi,37",
            "leo,36",
            "filomena,19",
            "invalido,abc",
            "lineaInvalida"

        );


        ValidadorDatos validador = new ValidadorDatos();
        List<Persona> personas = validador.procesarLineas(lineas);

        // genero los asserts:

        assertEquals(4, personas.size());
        assertEquals("maxi", personas.get(1).getNombre());
        assertEquals(22, personas.get(0).getEdad());



    }

}


package com.etapa1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonaTest {
    
    Persona p = new Persona("maxi", 37);
    
    @Test
    public void testSetEdad(){
        
        assertEquals(37, p.getEdad());
    }

    @Test
    public void testGetNombre(){
        assertEquals("maxi", p.getNombre());
    }
}

package com.etapa1;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.etapa1.Numeros.Project;

public class ProjectTest {
    Project p = new Project("Proyecto1", 5000, "abc123token");

    @Test
    public void testGetNombre(){
        assertEquals("Proyecto1", p.getNombre());
    }

    @Test
    public void testGetToken(){
        assertEquals("abc123token", p.getToken());
    }

    @Test
    public void testGetTimeOutMs(){
        assertEquals(5000, p.getTimeOutMs());
    }
}

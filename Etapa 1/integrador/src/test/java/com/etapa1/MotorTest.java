package com.etapa1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.etapa1.Autos.Motor;

public class MotorTest {
    @Test
    public void testMotorCreation() {
        Motor motor = new Motor("V6", 300);

        assertEquals("v6", motor.getModelo().toLowerCase(), "El modelo del motor debe ser V6");
        assertEquals(300, motor.getCaballosDeFuerza(), "Los caballos de fuerza del motor deben ser 300");
    }

}

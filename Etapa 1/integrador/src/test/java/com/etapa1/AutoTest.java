package com.etapa1;

import org.junit.jupiter.api.Test;

public class AutoTest {

    @Test
    public void testAutoCreation() {
        //Motor motor = new Motor("V8", 450);
        // ahora se crea el auto usando composicion, no es necesario crear el motor aparte
        Auto auto = new Auto("Ford","Mustang", "V8", 450);

        assert auto.getModelo().equals("Mustang");
        assert auto.getMotor().getModelo().equals("V8");
        assert auto.getMotor().getCaballosDeFuerza() == 450;
    }

}

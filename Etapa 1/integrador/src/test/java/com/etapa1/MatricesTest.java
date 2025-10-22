package com.etapa1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MatricesTest {
    
    

    // testeamos las funciones:

    @Test
    public void duplicarValoresTest (){
        Matrices mat = new Matrices();
        mat.showMatriz();
        mat.duplicarValores();
        assertEquals(2, mat.getMatriz()[0][0] );
        assertEquals(true, mat.duplicada);
        mat.showMatriz();
    }
    
}

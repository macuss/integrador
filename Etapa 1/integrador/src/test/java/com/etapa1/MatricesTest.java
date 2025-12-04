package com.etapa1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.etapa1.Numeros.Matrices;

public class MatricesTest {
    

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

package com.etapa1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.etapa1.Calculator.Calculadora;

public class CalculadoraTest {
    @Test
    public void testSumar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.sumar(2, 3);
        assert(resultado == 5);
        assertEquals(5, resultado, "La suma de 2 y 3 debe ser 5");
    }

    @Test
    public void testRestar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.restar(10, 3);
        assert(resultado == 7);
        assertEquals(7, resultado, "La resta de 10 y 3 debe ser 7");
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 6",  // 2*3=6
        "4, 5, 20", // 4*5=20
        "0, 10, 0", // 0*10=0
        "-2, 3, -6", // -2*3=-6
        "-4, -5, 20" // -4*-5=20
    })
    public void testMultiplicar(int a, int b, int expected) {
        Calculadora calc = new Calculadora();
        assertEquals(expected, calc.multiplicar(a,b), "La multiplicación de " + a + " y " + b + " debe ser " + expected);
    }
    
    @Test
    public void testDividirPorCero() {
        Calculadora calc = new Calculadora();
        assertThrows(ArithmeticException.class, () -> {
            calc.dividir(10, 0);
        }, "Dividir por cero debe lanzar una ArithmeticException");
    }
    
    @ParameterizedTest
    @CsvSource({
        "2, 3, 8",   // 2^3=8
        "5, 0, 1",   // 5^0=1
        "3, 2, 9",   // 3^2=9
        "4, 1, 4",   // 4^1=4
        "2, 5, 32"   // 2^5=32
    })
    public void testPotenciar(int base, int exponente, int expected) {
        Calculadora calc = new Calculadora();
        assertEquals(expected, calc.potenciar(base, exponente), "La potencia de " + base + " elevado a " + exponente + " debe ser " + expected);
    }

    @Test
    public void testPotenciarExponenteNegativo() {
        Calculadora calc = new Calculadora();
        assertThrows(ArithmeticException.class, () -> {
            calc.potenciar(2, -3);
        }, "Elevar a un exponente negativo debe lanzar una ArithmeticException");
    }

}

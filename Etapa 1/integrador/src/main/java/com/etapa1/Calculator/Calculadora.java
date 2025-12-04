package com.etapa1.Calculator;

public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }

    public int potenciar(int base, int exponente) {
        int resultado = 1;
        if(exponente < 0){
            throw new ArithmeticException("El exponente no puede ser negativo");
        }
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }
}

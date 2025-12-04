package com.etapa1.Autos;

public class Motor {
    private String modelo;
    private int caballosDeFuerza;

    public Motor(String modelo, int caballosDeFuerza) {
        this.modelo = modelo;
        this.caballosDeFuerza = caballosDeFuerza;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCaballosDeFuerza() {
        return caballosDeFuerza;
    }
    
}

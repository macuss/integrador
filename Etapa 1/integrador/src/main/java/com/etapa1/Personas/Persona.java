package com.etapa1.Personas;

public class Persona {
    private String nombre;
    private int edad;

    // constructor
    public Persona(String nombre, int edad){
        this.edad = edad;
        this.nombre = nombre;
    }

    // Getters
    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    // Setters

    public void setEdad(int edad){
        this.edad = edad;
    }


    
}

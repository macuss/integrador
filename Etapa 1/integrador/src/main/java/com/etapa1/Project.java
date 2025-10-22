package com.etapa1;

public class Project {
    private String nombre;
    private int timeOutMs;
    private String token;

    public Project(String nombre, int timeOutMs, String token) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }
        if (timeOutMs < 100 || timeOutMs > 10000) {
                throw new IllegalArgumentException("El timeOutMs debe estar entre 100 y 10k");
        }
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("El token no puede ser nulo o vacio");
        }

        this.nombre = nombre;
        this.timeOutMs = timeOutMs;
        this.token = token;
    }

    public Project(){
        this.nombre = "Sin nombre";
        this.timeOutMs = 1000;
        this.token = "defaulttoken";
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    public int getTimeOutMs() {
        return timeOutMs;
    }
    public String getToken() {
        return token;
    }

    // Setters con validaciones similares a las del constructor SIN TOKEN
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }
        this.nombre = nombre;
    }
    public void setTimeOutMs(int timeOutMs) {
        if (timeOutMs < 100 || timeOutMs > 10000) {
            throw new IllegalArgumentException("El timeOutMs debe estar entre 100 y 10k");
        }
        this.timeOutMs = timeOutMs;
    }

    // actualizar timeOut
    public void actualizarTimeOut(int nuevoTimeOut) {
        if( nuevoTimeOut < 100 || nuevoTimeOut > 10000) {
            throw new IllegalArgumentException("El timeOutMs debe estar entre 100 y 10k");
        }
        setTimeOutMs(nuevoTimeOut);
    }
    

}

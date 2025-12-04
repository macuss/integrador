package com.etapa1.Autos;

public class Auto {

    private String marca;
    private String modelo;
    private Motor motor;

    // uso de composicion con Motor
    public Auto(String marca, String modelo, String modeloMotor, int caballosDeFuerza) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = new Motor(modeloMotor, caballosDeFuerza);
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public Motor getMotor() {
        return motor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        
        return "Auto [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
    }

}

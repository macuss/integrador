package com.etapa1.Numeros;

import java.math.BigInteger;
import java.util.Arrays;

public class Matrices {

    private int [][] matriz;
    public Boolean duplicada;
    
    //constructor - crea una matriz cuadrada predeterminada
    public Matrices(){
       this.matriz = new int [][]{
            {1,2,3},
            {7,8,9},
            {12,13,14},
       };
       this.duplicada = false;
    } 

    public int[][] getMatriz() {
        return this.matriz;
    }

    public void setMatriz(int[][] mat){
        this.matriz = mat;
    }


    // multiplica por un N los valores internos de la matriz
    public void multiplicador(int n){

        for(int i=0; i< this.matriz.length; i++){
            for(int j=0; j < this.matriz.length; j++){
                this.matriz[i][j] =  this.matriz[i][j] * n;
            }
        }
    }

    public void duplicarValores(){
        this.multiplicador(2);
        this.duplicada = true;
        System.out.println("los valores han sido duplicados!");
    }

    // muestra la matriz por pantalla
    public void showMatriz(){
        System.out.println("La matriz cuadrada es: ");
        for(int i=0;i< this.matriz.length; i++){
            for(int j=0; j< this.matriz.length; j++){
                System.out.print(this.matriz[i][j]+" ");
            }
            System.out.println();
        }
    
    }

    public void setDuplicada(Boolean duplicada) {
        this.duplicada = duplicada;
    }

    @Override
    public String toString() {
        return "Matrices [matriz=" + Arrays.toString(matriz) + ", duplicada=" + duplicada + "]";
    }

    public static void main(String[] args){

        // prueba del operador ternario
        int edad = 20;
        String estado = (edad < 18) ? "menor" : "adulto"; 
        BigInteger CUIL = (edad > 21) ? BigInteger.valueOf(20335187327L) : BigInteger.valueOf(33518732L); 
        System.out.println("la persona tiene "+ edad + " años, es " + estado + " y su CUIL es: " + CUIL);
    }


}

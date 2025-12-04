package com.etapa1.Personas;

import java.util.ArrayList;
import java.util.List;


public class ValidadorDatos {
  // tiene 2 funciones, 1: procesar las lineas y 2: validar cada linea
  // la idea es almacenar en una coleccion de Personas solo las validas.
  
  
    public List<Persona> procesarLineas(List<String> lineas){
        // Lee una lista de strings (lineas) como si fueran líneas de un archivo.
        // crea una instancia de Persona por cada linea validada

        List<Persona> personas = new ArrayList<>();
       
        for(String linea: lineas){
            if(validarLinea(linea)){
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                int edad = Integer.parseInt(partes[1].trim());
                personas.add(new Persona(nombre, edad));

            } else {
                System.out.println("Linea invalida: "+ linea);
            }
        }


        return personas;

    }


    private Boolean validarLinea(String linea){
        // Valida el formato: que tenga coma, dos partes, y que la segunda parte sea número.
        if(linea == null || linea.isBlank() || !linea.contains(",")){
            return false;
        }

        String[] partes = linea.split(",");
        if (partes.length != 2){
            System.out.println("El archivo no tiene 2 partes");
            return false;
        }

        //controla que el parametro edad sea un numero entero
        try{
            Integer.parseInt(partes[1].trim());
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

}

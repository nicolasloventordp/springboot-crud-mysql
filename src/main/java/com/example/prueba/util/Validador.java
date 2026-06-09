package com.example.prueba.util;

public class Validador {
    
    public static void validarNombre(String nombre){
        if(nombre.isEmpty() || nombre == null){
            throw new IllegalArgumentException("EL nombre no puede estar vacío");
        }
    }
}

package com.example.prueba.util;

public class Validador {
    
    public static void validarNombre(String nombre){
        if(nombre.isEmpty() || nombre == null){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public static void validarCategoria(String categoria){
        if(categoria.isEmpty() || categoria == null){
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }
    }
}

package com.example.prueba.excepcion;

public class ProductoInexistente extends Exception{
    
    public ProductoInexistente(String msj){
        super(msj);
    }
}

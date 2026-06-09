package com.example.prueba.model;

public class Producto {

    private int id;
    private String nombre;

    public Producto(String nombre){
        this.nombre = nombre;
    }

    public Producto(){

    }

    //setters
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setId(int id){ this.id = id; }
    //getters
    public String getNombre(){ return this.nombre; }
    public int getId(){ return this.id; }

    //toString
    @Override
    public String toString(){
        return this.nombre;
    }

}

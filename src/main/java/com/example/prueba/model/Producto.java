package com.example.prueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

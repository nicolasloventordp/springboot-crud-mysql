package com.example.prueba.model;

import jakarta.persistence.Column;
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
    // id tipo long para que mysql genere automaticamente un id autoincremetal
    private long id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "categoria", length = 50)
    private String categoria;

    public Producto(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
        this.categoria = null;
    }

    public Producto() {

    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // getters
    public String getNombre() {
        return this.nombre;
    }

    public long getId() {
        return this.id;
    }

    public String getCategoria() {
        return this.categoria;
    }

    // toString
    @Override
    public String toString() {
        return this.nombre;
    }

}

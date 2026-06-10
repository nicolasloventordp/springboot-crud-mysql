package com.example.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.model.Producto;
 
// Interfaz vacía. hereda save, findById, finAll, deleteById, etc.
// Spring genera la implementación en tiempo de ejecución. No hace falta escribir consultas SQL.
// <Producto, Integer> Entidad que maneja y tipo de su clave primaria.
public interface ProductoRepository extends JpaRepository<Producto,Integer>{
    
}

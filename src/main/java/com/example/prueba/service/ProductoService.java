package com.example.prueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.prueba.excepcion.ProductoInexistente;
import com.example.prueba.model.Producto;
import com.example.prueba.repository.ProductoRepository;
import com.example.prueba.util.Validador;

@Service
public class ProductoService {
    // atributos
    private List<Producto> productos = new ArrayList<>();
    private ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }
    // lista todos los productos
    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    // Obtiene un producto por id si no existe lanza excepción
    public Producto obtenerPorId(int id) throws ProductoInexistente {
        return repository.findById(id)
                .orElseThrow( () -> new ProductoInexistente("No hay producto con id " + id));
        
    }

    // guarda un producto
    public Producto guardar(Producto p) {
        Validador.validarNombre(p.getNombre());
        Validador.validarCategoria(p.getCategoria());
        repository.save(p);
        return p;
    }

    // actualizar un producto
    public Producto actualizar(int id, Producto datos) throws ProductoInexistente {
        Producto p = obtenerPorId(id);
        // si no encuentra el producto lanza excepcion ProductoInexistente
        Validador.validarNombre(datos.getNombre());
        Validador.validarCategoria(datos.getCategoria());
        p.setNombre(datos.getNombre());
        p.setCategoria(datos.getCategoria());
        repository.save(p);
        return p;
    }

    // eliminar producto
    public void eliminar(int id) throws ProductoInexistente {
        Producto p = obtenerPorId(id);
        repository.delete(p);
    }

}

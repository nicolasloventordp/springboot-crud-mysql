package com.example.prueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.prueba.excepcion.ProductoInexistente;
import com.example.prueba.model.Producto;
import com.example.prueba.util.Validador;

@Service
public class ProductoService {
    // atributos
    private List<Producto> productos = new ArrayList<>();
    private int contadorId = 0;

    // lista todos los productos
    public List<Producto> listarTodos() {
        return productos;
    }

    // Obtiene un producto por id si no existe lanza excepción
    public Producto obtenerPorId(int id) throws ProductoInexistente {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new ProductoInexistente("No hay producto con id " + id);
    }

    // guarda un producto
    public Producto guardar(Producto p) {
        Validador.validarNombre(p.getNombre());
        p.setId(contadorId);
        productos.add(p);
        contadorId++;
        return p;
    }

    // actualizar un producto
    public Producto actualizar(int id, Producto p) throws ProductoInexistente {
        Producto encontrado = obtenerPorId(p.getId());
        // si no lo encuentra lanza excepción
        Validador.validarNombre(encontrado.getNombre());
        encontrado.setNombre(p.getNombre());
        return p;
    }

    // eliminar producto
    public boolean eliminar(int id) {
        return productos.removeIf( p -> p.getId() == id);
    }

}

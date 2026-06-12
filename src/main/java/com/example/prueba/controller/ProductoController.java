package com.example.prueba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.model.Producto;
import com.example.prueba.service.ProductoService;
import com.example.prueba.util.ErrorMsj;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // Maneja requests HTTP y serializa las respuestas JSON.
@RequestMapping("/productos") // Define la url base de todos los endpoints de la clase.
public class ProductoController {

    // Inyección por constructor
    private ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // GET /productos - 200 con la lista de productos (puede estar vacía).
    @GetMapping()
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // GET /productos/{id} - 200 si existe, 404 si no.
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable int id) {
        try {
            Producto encontrado = service.obtenerPorId(id);
            return ResponseEntity.ok(encontrado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMsj(e.getMessage()));
        }
    }

    // POST /productos - 201 con producto creado. 404 si el nombre viene vacío.
    @PostMapping()
    public ResponseEntity<?> guardarProducto(@RequestBody Producto p) {
        try {
            Producto creado = service.guardar(p);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMsj(e.getMessage()));
        }
    }

    // PUT /productos/{id} - 200 si existe con el producto actualizado, 404 si no.
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable int id, @RequestBody Producto datos) {
        try {
            //return ResponseEntity.ok(datos);
            Producto actualizado = service.actualizar(id, datos);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMsj(e.getMessage()));
        }
    }

    // DELETE /productos/{id} - 200 si elimina con confirmacion(false o true), 404 si no.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        try {
            boolean borrado = service.eliminar(id);
            return ResponseEntity.ok(borrado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMsj(e.getMessage()));
        }
    }
}

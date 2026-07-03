package com.techlab.ecommerce.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.ProductoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    // Inyección por constructor: Spring crea el ProductoService
    // y lo pasa automáticamente al controlador.
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // GET /productos — devuelve la lista de todos los productos
    // Devuelve 200 OK con la lista de productos (puede estar vacía)
    // GET /productos — devuelve todos los productos en formato JSON
    @GetMapping
    public ResponseEntity<List<Producto>> listarTodos() {
        List<Producto> productos = service.listarTodos();
        return ResponseEntity.ok(productos);
    }

    // Si existe: 200 OK con el producto
    // Si no existe: 404 Not Found — el servicio lanza ProductoNoEncontradoException
    // GET /productos/{id} — devuelve un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        Producto producto = service.obtenerPorId(id);
        return ResponseEntity.ok(producto);
    }

    // Devuelve 201 Created con el producto creado — el servicio asigna el ID
    // automáticamente
    // POST /productos — crea un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@Valid @RequestBody Producto nuevoProducto) {
        Producto creado = service.guardar(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // Si existe: 200 OK con el producto actualizado
    // Si no existe: 404 Not Found
    // PUT /productos/{id} — actualiza un producto por ID
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id,@Valid @RequestBody Producto datos) {    
        Producto actualizado = service.actualizar(id, datos);
        return ResponseEntity.ok(actualizado);
 
    }

    // Si existe: 200 OK sin body — el producto fue eliminado
    // Si no existe: 404 Not Found
    // DELETE /productos/{id} — elimina un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok().build();   
    }

    //GET /productos/nombre/{nombre} — devuelve la lista de productos que contienen el nombre dado
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Producto>> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    //GET /productos/categoria/{categoria} — devuelve la lista de productos que pertenecen a la categoría dada
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Producto>> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(service.buscarPorCategoria(categoria));
    }
}
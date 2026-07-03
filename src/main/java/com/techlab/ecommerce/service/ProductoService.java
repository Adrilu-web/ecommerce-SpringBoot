package com.techlab.ecommerce.service;



import com.techlab.ecommerce.exception.ProductoNoEncontradoException;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.ProductoRepository;

import org.springframework.stereotype.Service;


import java.util.List;


@Service // Anotación de Spring que indica que esta clase es un servicio.
// Sin esta anotación, Spring no la detecta y no la inyecta en el controlador.
public class ProductoService {

    // Inyección por constructor: Spring pasa el repositorio.
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }
    
    // CREATE:
    public Producto guardar(Producto p) {      
        return repository.save(p);
    }

    // READ: devuelve toda la lista de productos.
    public List<Producto> listarTodos() {
        return repository.findAll();
    }
    

    // READ: busca un producto por id. Si no existe, lanza excepción.
    public Producto obtenerPorId(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("No se encontró un producto con id " + id));
    }


    // UPDATE: actualiza los datos de un producto existente.
    public Producto actualizar(Integer id, Producto datos) {

        Producto p = obtenerPorId(id);
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
         if (datos.getImagenUrl() != null) {
            p.setImagenUrl(datos.getImagenUrl());};

        p.setCategoria(datos.getCategoria());
        return repository.save(p);
    }

    // DELETE: elimina un producto por id.
    public void eliminar(Integer id) {
        Producto p = obtenerPorId(id);
        repository.delete(p);
    }


    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }

    public List<Producto> buscarPorCategoria(String categoria) {
        return repository.findByCategoriaNombreContainingIgnoreCase(categoria);
    }
}

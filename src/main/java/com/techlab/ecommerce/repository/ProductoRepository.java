package com.techlab.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlab.ecommerce.model.Producto;


public interface  ProductoRepository extends JpaRepository<Producto, Integer> {
    
    // Containing → LIKE %valor%
    List<Producto> findByNombreContaining(String nombre);

    // Navega la relación hacia Categoria.
    // IgnoreCase → sin distinción de mayúsculas
    // Containing → LIKE %valor%
    List<Producto> findByCategoriaNombreContainingIgnoreCase(String nombre);
}

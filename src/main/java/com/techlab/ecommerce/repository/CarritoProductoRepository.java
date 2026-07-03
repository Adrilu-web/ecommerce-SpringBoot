package com.techlab.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlab.ecommerce.model.Carrito;
import com.techlab.ecommerce.model.CarritoProducto;
import com.techlab.ecommerce.model.Producto;

import java.util.Optional;

public interface CarritoProductoRepository extends JpaRepository<CarritoProducto, Integer> {

    // Busca si ya existe una fila con ese carrito y ese producto.
    // Si existe, incrementamos la cantidad. Si no, creamos una nueva fila.
    Optional<CarritoProducto> findByCarritoAndProducto(Carrito carrito, Producto producto);
}
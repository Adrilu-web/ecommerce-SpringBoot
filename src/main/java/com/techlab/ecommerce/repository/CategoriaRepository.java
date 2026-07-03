package com.techlab.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlab.ecommerce.model.Categoria;


// Interfaz vacía: hereda save, findById, findAll, deleteById y más de JpaRepository.
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {   
}

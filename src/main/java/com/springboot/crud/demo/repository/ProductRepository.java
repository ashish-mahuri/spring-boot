package com.springboot.crud.demo.repository;

import com.springboot.crud.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

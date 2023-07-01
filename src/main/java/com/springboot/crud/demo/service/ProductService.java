package com.springboot.crud.demo.service;

import com.springboot.crud.demo.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    Product updateProduct(long id, Product product);
    List<Product> getAllProduct();
    Product getProductById(long id);
    void deleteProduct(long id);

}

package com.springboot.crud.demo.service;

import com.springboot.crud.demo.exception.ResourceNotFound;
import com.springboot.crud.demo.model.Product;
import com.springboot.crud.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(long number, Product product) {
        Optional<Product> fetchProductFromDB = this.productRepository.findById(product.getId());
        if(fetchProductFromDB.isPresent()){
            Product updatedProduct = fetchProductFromDB.get();
            updatedProduct.setId(product.getId());
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            productRepository.save(updatedProduct);
            return updatedProduct;
        } else {
            throw new ResourceNotFound("Product not found with ID: " + product.getId());
        }
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<Product>();
        products = this.productRepository.findAll();
        return products;
    }

    @Override
    public Product getProductById(long id) {

        Optional<Product> product = this.productRepository.findById(id);

        if(product.isPresent()) {
            return product.get();
        } else {
            throw new ResourceNotFound("Product not found with id: " + id);
        }
    }

    @Override
    public void deleteProduct(long id) {

        Optional<Product> product = this.productRepository.findById(id);

        if(product.isPresent()) {
            this.productRepository.delete(product.get());
        } else {
            throw new ResourceNotFound("Product not found with Id: " + id + ". So not able to delete.");
        }
    }
}

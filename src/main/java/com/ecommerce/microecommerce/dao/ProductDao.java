package com.ecommerce.microecommerce.dao;

import com.ecommerce.model.Product;

import java.util.List;

public interface ProductDao {
    // Names of methods aren't randomly chosen
    // For more details : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    public List<Product> findAll();
    public Product findById(int id);
    public Product save(Product product);
}

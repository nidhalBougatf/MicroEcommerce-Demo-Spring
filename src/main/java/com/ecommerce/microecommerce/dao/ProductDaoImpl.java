package com.ecommerce.microecommerce.dao;

import com.ecommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // Specifying to spring that this class is used for Data Management , so we can use some features later ( like error
public class ProductDaoImpl implements ProductDao {

    public static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "MicroWave", 350));
        products.add(new Product(2, "Computer", 500));
        products.add(new Product(3, "TV", 750));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product p :products)
        {
            if (p.getId()== id)
                return p;
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}

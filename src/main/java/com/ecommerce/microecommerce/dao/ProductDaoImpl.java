package com.ecommerce.microecommerce.dao;

// ********************* No longer needed after extending from JPARepository in ProductDaoInterface **********************************************


/*
@Repository // Specifying to spring that this class is used for Data Management , so we can use some features later ( like logging management ...)
public class ProductDaoImpl implements ProductDao {

    public static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "MicroWave", 350,300));
        products.add(new Product(2, "Computer", 500,400));
        products.add(new Product(3, "TV", 750,650));
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
*/
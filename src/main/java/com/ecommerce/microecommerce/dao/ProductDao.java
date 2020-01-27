package com.ecommerce.microecommerce.dao;

import com.ecommerce.microecommerce.dao.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // added after deleting ProductDaoImpl (  this became our Data management interface )
public interface ProductDao extends JpaRepository<Product, Integer>  // when inheriting from JpaRepository , we need to specify type of object, and type of its ID
{
    // Names of methods aren't randomly chosen, for more details : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    // Another useful link , https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
    public List<Product> findAll();
    public Product save(Product product);
    public void delete(Product product);

    // One of the best features of JPA ,the auto-generated methods from conventions
    // for more details : https://docs.spring.io/spring-data/data-jpa/docs/1.1.x/reference/html/#jpa.query-methods.query-creation
    public Product findById(int id);
    public Product findByName(String name);
    public List<Product> findByPriceGreaterThan(int limitedprice);

    //Or using JPQL to create the query manually
    @Query("SELECT p.id, p.name, p.price FROM Product p WHERE p.price > :limitedPrice")
    public List<Product>  chercherUnProduitCher(@Param("limitedPrice") int price);


}

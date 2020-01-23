package com.ecommerce.microecommerce.web.controller;

import com.ecommerce.microecommerce.dao.ProductDao;
import com.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// This annotation is used to tell Spring that this class will:
//   - deal with HTTP requests ( Get, Post, ...)
//   - will return JSON data without passing through any views
@RestController
public class ProductController {

    @Autowired //  tell Spring that it should automtically create an instance of this class
    private ProductDao productDao;


    // mentionning the name of the URI and the HTTP request type
    @RequestMapping(value="/products",method = RequestMethod.GET)
    public List<Product> listProducts()
    {
        return productDao.findAll();
    }

    // OR @GetMapping(value = "/Produits/{id}") // to avoid putting two arguments ( value and method )
    @RequestMapping(value="/products/{id}",method=RequestMethod.GET)
    public Product DisplayProduct(@PathVariable int id) { // @PathVariable 'id' and the name mentionned between the brackets {id} should be the same
        return productDao.findById(id);
    }


    @PostMapping(value="products/add")
    // @RequestBody : Telling Sping to convert the JSON object, comming from the request, to a JAVA object ( product in this case)
    public void AddProduct (@RequestBody Product product)
    {
        productDao.save(product);
    }









}

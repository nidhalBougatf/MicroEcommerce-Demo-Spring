package com.ecommerce.microecommerce.web.controller;

import com.ecommerce.microecommerce.dao.ProductDao;
import com.ecommerce.model.Product;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


// This annotation is used to tell Spring that this class will:
//   - deal with HTTP requests ( Get, Post, ...)
//   - will return JSON data without passing through any views
@RestController
public class ProductController {

    @Autowired //  tell Spring that it should automtically create an instance of this class
    private ProductDao productDao;


    // 1 method : returning the list of products
    // mentionning the name of the URI and the HTTP request type
    @RequestMapping(value="/products",method = RequestMethod.GET)
    public List<Product> listProducts()
    {
        return productDao.findAll();
    }
    /*
    // 2 returning the list of FILTERED products ( exculding providerPrice property )
    @GetMapping(value = "/products")
    public MappingJacksonValue listProducts2() {

        // getting the list of all products
        List<Product> products = productDao.findAll();
        // creating the filter ( exclude providerPrice property )
        SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.serializeAllExcept("providerPrice"); // filterOutAllExcept (prop) => exclude all except prop
        // Adding the filter and associating it with the all Beans that uses 'MyDynamicFilter' ( in this case , only Product Bean)
        FilterProvider allFilters = new SimpleFilterProvider().addFilter("MyDynamicFilter", myFilter);
        // Preparing the list of filtered products, in which we'ill apply the filter created previously
        MappingJacksonValue filteredProducts = new MappingJacksonValue(products);
        filteredProducts.setFilters(allFilters);

        return filteredProducts;
    }
*/
    // OR @GetMapping(value = "/Produits/{id}") // to avoid putting two arguments ( value and method )
    @RequestMapping(value="/products/{id}",method=RequestMethod.GET)
    public Product DisplayProduct(@PathVariable int id) { // @PathVariable 'id' and the name mentionned between the brackets {id} should be the same
        return productDao.findById(id);
    }


    @PostMapping(value="products")
    // @RequestBody : Telling Spring to convert the JSON object, comming from the request, to a JAVA object ( product in this case)
        public ResponseEntity<Void> AddProduct(@RequestBody Product product) {

        Product productAdded =  productDao.save(product);

        // in case the product is empty ( no content) , 204 code is returned
        if (productAdded == null)
            return ResponseEntity.noContent().build();

        // in case product was successfully added, 201 code and the URI of the added product will be returned
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }










}
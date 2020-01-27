package com.ecommerce.microecommerce.web.controller;

import com.ecommerce.microecommerce.dao.ProductDao;
import com.ecommerce.microecommerce.dao.model.Product;
import com.ecommerce.microecommerce.web.exceptions.ProductNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


// This annotation is used to tell Spring that this class will:
//   - deal with HTTP requests ( Get, Post, ...)
//   - will return JSON data without passing through any views
@Api( value="API used for managing the products ")
@RestController
public class ProductController {

    @Autowired //  to automatically create an instance of this interface
    private ProductDao productDao;

    @ApiOperation(value=" method used to display the list of all products ")
    @RequestMapping(value="/products",method = RequestMethod.GET)
    public List<Product> listProducts()
    {
        return productDao.findAll();
    }
    @ApiOperation(value=" method used for getting a product by its id ")
    @GetMapping(value="/products/{id}")
    public Product GetProductById(@PathVariable int id)
    {
        Product product = productDao.findById(id);
        if(product==null)
            throw new ProductNotFoundException("Product having id = "+id+" is not found !");
        return product;

    }
    @ApiOperation(value=" method used to display products having a price greater than a given value")
    @GetMapping(value = "test/price/{priceLimit}") // changed the path for later example in Swagger
    public List<Product> LimitedPriceProducts(@PathVariable int priceLimit) {
        return productDao.findByPriceGreaterThan(priceLimit);
    }

    @ApiOperation(value=" method used for adding a product ")
    @PostMapping(value="/products")
    // @RequestBody : to convert the JSON object, coming from the request, to a JAVA object ( product in this case)
    // @Valid : to check for the validators added in Product Bean before accepting the product and add it in the database
    public ResponseEntity<Void> AddProduct(@Valid @RequestBody Product product) {

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
    @ApiOperation(value=" method used to delete a product, given by its id, from the database ")
    @DeleteMapping (value = "/products/{id}")
    public void deleteProduct(@PathVariable int id) {
       Product p=  productDao.findById(id);
       productDao.delete(p);
    }

    @ApiOperation(value=" method used to update a specific product ")
    @PutMapping (value = "/products")
    public void updateProduct(@RequestBody Product product) {
        productDao.save(product);
    }











//*********************************** Methods used in 1st version ( before adding connection with database ******************************************************
   /*
            // 1 method : returning the list of products
            // mentionning the name of the URI and the HTTP request type
            @RequestMapping(value="/products",method = RequestMethod.GET)
            public List<Product> listProducts()
            {
                return productDao.findAll();
            }

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

    */








}

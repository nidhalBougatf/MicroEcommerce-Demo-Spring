package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Note:  In this Bean (or JavaBean), Constructor, Getters & Setters are mandatory


//@JsonIgnoreProperties(value={"id","providerPrice"}) // static filter method 2: In case we have multiple properties to hide
//@JsonFilter("MyDynamicFilter") // 1/ a dynmaic filter used in case we want to hide a specific property, depending on something (type of users for example) , 2/ Next step , add the filter & edit 'listProducts()' method in ProductController
public class Product {


    private int id;
    private String name;
    private int price;
    //@JsonIgnore // static filter method 1 , used to hide this property while displaying ( replaced later by the dynamic filter )
    private int providerPrice;


    public Product() {
    }

    public Product(int id, String name, int price, int providerPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.providerPrice=providerPrice;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", providerPrice=" + providerPrice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProviderPrice() {  return providerPrice; }

    public void setProviderPrice(int providerPrice) { this.providerPrice = providerPrice;  }
}

package com.ecommerce.microecommerce.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Note:  In this Bean (or JavaBean), Constructor, Getters & Setters are mandatory


//@JsonIgnoreProperties(value={"id","providerPrice"}) // static filter method 2: In case we have multiple properties to hide
//@JsonFilter("MyDynamicFilter") // 1/ a dynamic filter used in case we want to hide a specific property, depending on something (type of users for example) , 2/ Next step , add the filter & edit 'listProducts()' method in ProductController
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    //@JsonIgnore // static filter method 1 , used to hide this property while displaying ( replaced later by the dynamic filter )
    private int providerprice;


    public Product() {
    }

    public Product(int id, String name, int price, int providerprice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.providerprice=providerprice;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", providerPrice=" + providerprice +
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

    public int getProviderprice() {  return providerprice; }

    public void setProviderprice(int providerPrice) { this.providerprice = providerPrice;  }
}

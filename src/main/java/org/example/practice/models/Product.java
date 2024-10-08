package org.example.practice.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product  extends BaseEntity{

    private String name;
    private double price;
    private Set<ListOfProduct> listOfProducts;


    public Product(String name,double price){
        this.name = name;
        this.price = price;
    }

    protected Product() {

    }

    @Column(name = "product_name")
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    @Column(name = "price")
    public double getPrice() { return price;}
    public void setPrice(double price) { this.price = price;}

    @OneToMany(mappedBy = "product", targetEntity = ListOfProduct.class)
    public Set<ListOfProduct> getListOfProducts() {
        return listOfProducts;
    }
    public void setListOfProducts(Set<ListOfProduct> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
}

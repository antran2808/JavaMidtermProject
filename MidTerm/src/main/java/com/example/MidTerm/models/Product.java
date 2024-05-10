package com.example.MidTerm.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int code;
    private  String name;
    private double price;
    private String brand;
    private String description;
    private String imageProduct;


    public Product(String s, float v, String brand, String s1, String s2) {
        this.name = s;
        this.price = v;
        this.brand = brand;
        this.description = s1;
        this.imageProduct = s2;
    }

    public Product() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

}

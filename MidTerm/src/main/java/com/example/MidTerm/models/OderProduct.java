package com.example.MidTerm.models;

import jakarta.persistence.*;
@Entity
@Table(name = "OderProduct")
public class OderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oder_id")
    private Oder oder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public OderProduct(Oder oder, Product product) {
        this.oder = oder;
        this.product = product;
    }

    public OderProduct() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Oder getOder() {
        return oder;
    }

    public void setOder(Oder oder) {
        this.oder = oder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

package com.example.MidTerm.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Oder")
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "oder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OderProduct> oderProducts;

    public Oder(User user, List<OderProduct> oderProducts) {
        this.user = user;
        this.oderProducts = oderProducts;
    }

    public Oder() {

    }
    public Oder(User user){
        this.user = user;
    }

    public List<OderProduct> getOderProducts() {
        return oderProducts;
    }

    public void setOderProducts(List<OderProduct> oderProducts) {
        this.oderProducts = oderProducts;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

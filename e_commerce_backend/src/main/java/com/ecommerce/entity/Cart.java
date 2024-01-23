package com.ecommerce.entity;

import javax.persistence.*;

@Entity
@Table
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer catId;
    @OneToOne
    private Product product;
    @OneToOne
    private User user;

    public Cart(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

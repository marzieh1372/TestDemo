package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "USER_PRODUCT",uniqueConstraints = {@UniqueConstraint(columnNames= {"fk_user_id", "fk_product_id"})})
public class UserProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;



   /* @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "fk_user_id",referencedColumnName = "id")
    private User user;*/


    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "fk_user_id",referencedColumnName = "id",nullable = false)
    private Reseller resellerUser;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "fk_product_id",referencedColumnName = "id",nullable = false)
    private Product product;

    @Column
    private BigDecimal commission;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


   /* public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public Reseller getResellerUser() {
        return resellerUser;
    }

    public void setResellerUser(Reseller resellerUser) {
        this.resellerUser = resellerUser;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }
}

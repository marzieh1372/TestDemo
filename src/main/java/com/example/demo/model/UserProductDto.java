package com.example.demo.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class UserProductDto {
    private Long id;
    private String userName;
    @NotNull
    private String code;
    @NotNull
    private BigDecimal commission;
    @NotNull
    private long userId;
    @NotNull
    private long productId;

    public UserProductDto() {
    }

    public UserProductDto(User user , UserProduct userProduct) {
        this.id = userProduct.getId();
        this.userName = user.getUserName();
        this.code = userProduct.getResellerUser().getCode();
        this.commission = userProduct.getCommission();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}

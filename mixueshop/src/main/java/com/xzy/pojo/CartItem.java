package com.xzy.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by css on 2018/7/23.
 */
public class CartItem implements Serializable {
    private String id;
    private Integer number;
    private BigDecimal finalPay;
    private Date insertTime;
    private Integer priceId;
    private Integer productId;
    private Integer state;
    private String userId;
    private Price price;
    private Product product;
    private User user;

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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(BigDecimal finalPay) {
        this.finalPay = finalPay;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", finalPay=" + finalPay +
                ", insertTime=" + insertTime +
                ", priceId=" + priceId +
                ", productId=" + productId +
                ", state=" + state +
                ", userId='" + userId + '\'' +
                ", price=" + price +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}

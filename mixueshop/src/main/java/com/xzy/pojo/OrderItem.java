package com.xzy.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by css on 2018/7/23.
 */
public class OrderItem implements Serializable {
    private String id;
    private Integer number;
    private Date insertTime;
    private Integer state;
    private Integer priceId;
    private BigDecimal finalPay;
    private Integer productId;
    private String ordersId;
    private String userId;
    private List<ProductDiscuss> productDiscusses;
    private Product product;
    private Price price;
    private Orders orders;
    public Product getProduct() {
        return product;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public BigDecimal getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(BigDecimal finalPay) {
        this.finalPay = finalPay;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public List<ProductDiscuss> getProductDiscusses() {
        return productDiscusses;
    }

    public void setProductDiscusses(List<ProductDiscuss> productDiscusses) {
        this.productDiscusses = productDiscusses;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", insertTime=" + insertTime +
                ", state=" + state +
                ", priceId=" + priceId +
                ", finalPay=" + finalPay +
                ", productId=" + productId +
                ", ordersId='" + ordersId + '\'' +
                ", productDiscusses=" + productDiscusses +
                ", product=" + product +
                ", price=" + price +
                ", orders=" + orders +
                '}';
    }
}

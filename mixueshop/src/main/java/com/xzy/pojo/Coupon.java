package com.xzy.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by css on 2018/7/23.
 */
public class Coupon implements Serializable {
    private Integer id;
    private String name;
    private String descript;
    private BigDecimal limitPrice;
    private Integer number;
    private Integer buyNumber;
    private Date created;
    private Date updated;
    private Integer state;
    private BigDecimal apply;
    private Integer couponCategory;
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(BigDecimal limitPrice) {
        this.limitPrice = limitPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getApply() {
        return apply;
    }

    public void setApply(BigDecimal apply) {
        this.apply = apply;
    }

    public Integer getCouponCategory() {
        return couponCategory;
    }

    public void setCouponCategory(Integer couponCategory) {
        this.couponCategory = couponCategory;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private List<Product> products;

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                ", limitPrice=" + limitPrice +
                ", number=" + number +
                ", buyNumber=" + buyNumber +
                ", created=" + created +
                ", updated=" + updated +
                ", state=" + state +
                ", apply=" + apply +
                ", couponCategory=" + couponCategory +
                ", users=" + users +
                ", products=" + products +
                '}';
    }
}

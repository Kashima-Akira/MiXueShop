package com.xzy.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by css on 2018/7/23.
 */
public class Collect implements Serializable {
    private String id;
    private String descript;
    private Date collectTime;
    private Integer state;
    private String userId;
    private Integer productId ;
    private Product product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id='" + id + '\'' +
                ", descript='" + descript + '\'' +
                ", collectTime=" + collectTime +
                ", state=" + state +
                ", userId='" + userId + '\'' +
                ", productId=" + productId +
                ", product=" + product +
                '}';
    }
}

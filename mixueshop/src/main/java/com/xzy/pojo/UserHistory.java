package com.xzy.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by css on 2018/7/23.
 */
public class UserHistory implements Serializable {
    /*
    *  `id` VARCHAR(64) NOT NULL,
  `TIME` DATETIME DEFAULT NULL,
  `number` INT(11) DEFAULT NULL,
  `state` INT(11) DEFAULT NULL,
  `user_id` VARCHAR(64) DEFAULT NULL,
  `product_id` INT(11) DEFAULT NULL,
    * */
    private String id;
    private Date time;
    private Integer number;
    private Integer state;
    private String userId;
    private Integer productId;
    private Product product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
        return "UserHistory{" +
                "id='" + id + '\'' +
                ", time=" + time +
                ", number=" + number +
                ", state=" + state +
                ", userId='" + userId + '\'' +
                ", productId=" + productId +
                ", product=" + product +
                '}';
    }
}

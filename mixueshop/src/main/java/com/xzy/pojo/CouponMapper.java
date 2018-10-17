package com.xzy.pojo;

import java.io.Serializable;

/**
 * Created by css on 2018/7/23.
 */
public class CouponMapper implements Serializable {
    private String id;
    private String userId;
    private Integer productId;
    private Integer state;
    private Integer couponId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    @Override
    public String toString() {
        return "CouponMapper{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", productId=" + productId +
                ", state=" + state +
                ", couponId=" + couponId +
                '}';
    }
}

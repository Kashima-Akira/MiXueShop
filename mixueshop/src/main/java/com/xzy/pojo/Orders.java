package com.xzy.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by css on 2018/7/23.
 */
public class Orders implements Serializable {
    private String id;
    private String descript;
    private BigDecimal total;
    private BigDecimal finalPay;
    private String submitAddressId;
    private Date orderTime;
    private Integer state;
    private String userId;
    private List<OrderItem> orderItems;
    private User user;
    private SubmitAddress submitAddress;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubmitAddress getSubmitAddress() {
        return submitAddress;
    }

    public void setSubmitAddress(SubmitAddress submitAddress) {
        this.submitAddress = submitAddress;
    }


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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(BigDecimal finalPay) {
        this.finalPay = finalPay;
    }

    public String getSubmitAddressId() {
        return submitAddressId;
    }

    public void setSubmitAddressId(String submitAddressId) {
        this.submitAddressId = submitAddressId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", descript='" + descript + '\'' +
                ", total=" + total +
                ", finalPay=" + finalPay +
                ", submitAddressId='" + submitAddressId + '\'' +
                ", orderTime=" + orderTime +
                ", state=" + state +
                ", userId='" + userId + '\'' +
                ", orderItems=" + orderItems +
                ", user=" + user +
                ", submitAddress=" + submitAddress +
                '}';
    }
}

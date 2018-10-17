package com.xzy.pojo;


import java.io.Serializable;
import java.util.List;

/**
 * Created by css on 2018/7/23.
 */
public class User implements Serializable {
    private String id;
    private String name;
    private String password;
    private Integer level;
    private String image;
    private String telephone;
    private String email;
    private Integer state;
    private List<Activity> activitys;
    private List<CartItem> cartItems;
    private List<Collect> collect;
    private List<Coupon> coupons;
    private List<Orders> orderses;
    private List<SubmitAddress> submitAddresses;
    private List<UserHistory> userHistories;
    private String checkCode;

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Activity> getActivitys() {
        return activitys;
    }

    public void setActivitys(List<Activity> activitys) {
        this.activitys = activitys;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<Collect> getCollect() {
        return collect;
    }

    public void setCollect(List<Collect> collect) {
        this.collect = collect;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public List<Orders> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Orders> orderses) {
        this.orderses = orderses;
    }

    public List<SubmitAddress> getSubmitAddresses() {
        return submitAddresses;
    }

    public void setSubmitAddresses(List<SubmitAddress> submitAddresses) {
        this.submitAddresses = submitAddresses;
    }

    public List<UserHistory> getUserHistories() {
        return userHistories;
    }

    public void setUserHistories(List<UserHistory> userHistories) {
        this.userHistories = userHistories;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                ", image='" + image + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", state=" + state +
                ", activitys=" + activitys +
                ", cartItems=" + cartItems +
                ", collect=" + collect +
                ", coupons=" + coupons +
                ", orderses=" + orderses +
                ", submitAddresses=" + submitAddresses +
                ", userHistories=" + userHistories +
                '}';
    }
}

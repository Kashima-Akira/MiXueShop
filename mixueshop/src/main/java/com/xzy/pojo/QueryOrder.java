package com.xzy.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by css on 2018/7/24.
 */
public class QueryOrder implements Serializable {
    private List<String> cartItemIds;
    private String submitAddressId;
    private String descript;
    private User user;
    private Integer level;//该单的积分
    private Integer state;//要查的订单状态

    public int getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(int addPrice) {
        this.addPrice = addPrice;
    }

    private int addPrice;
    private int indexPage;
    private int pageNum;

    public int getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(int indexPage) {
        this.indexPage = indexPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public List<String> getCartItemIds() {
        return cartItemIds;
    }

    public void setCartItemIds(List<String> cartItemIds) {
        this.cartItemIds = cartItemIds;
    }

    public String getSubmitAddressId() {
        return submitAddressId;
    }

    public void setSubmitAddressId(String submitAddressId) {
        this.submitAddressId = submitAddressId;
    }

    @Override
    public String toString() {
        return "QueryOrder{" +
                "cartItemIds=" + cartItemIds +
                ", submitAddressId='" + submitAddressId + '\'' +
                ", descript='" + descript + '\'' +
                ", user=" + user +
                ", level=" + level +
                ", state=" + state +
                '}';
    }
}

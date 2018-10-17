package com.xzy.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class DiscussVo implements Serializable
{
    private String descript;
    private Integer state;
    private Integer productId;
    private String ordersId;
    private List<Map> image;

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public List<Map> getImage() {
        return image;
    }

    public void setImage(List<Map> image) {
        this.image = image;
    }
}

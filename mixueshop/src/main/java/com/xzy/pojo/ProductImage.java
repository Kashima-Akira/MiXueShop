package com.xzy.pojo;

import java.io.Serializable;

/**
 * Created by css on 2018/7/23.
 */
public class ProductImage implements Serializable {
    private String id;
    private String path;
    private String descript;
    private Integer productId;
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
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

    @Override
    public String toString() {
        return "ProductImage{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", descript='" + descript + '\'' +
                ", productId=" + productId +
                ", state=" + state +
                '}';
    }
}

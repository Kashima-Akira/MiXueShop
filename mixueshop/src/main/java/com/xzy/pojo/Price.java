package com.xzy.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by css on 2018/7/23.
 */
public class Price implements Serializable {
    private Integer id;
    private BigDecimal price;
    private String name;
    private String descript;
    private String image;
    private Integer state;
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                ", image='" + image + '\'' +
                ", state=" + state +
                ", productId=" + productId +
                '}';
    }
}

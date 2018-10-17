package com.xzy.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by css on 2018/7/23.
 */
public class Category implements Serializable {
    private Integer id;
    private String name;
    private String descript;
    private Integer state;
    private List<Product> products;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String
    toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                ", state=" + state +
                ", products=" + products +
                '}';
    }
}

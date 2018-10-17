package com.xzy.utils;

import com.xzy.pojo.Product;
import com.xzy.pojo.ProductImage;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ♕ Prince on 2018/8/3.
 */
public class finalGusses implements Serializable
{
    private float finalCount;

    private String name;

    private Integer id;
    private Integer categoryId;

    private List<ProductImage> imageList;


    public float getFinalCount() {
        return finalCount;
    }

    public void setFinalCount(float finalCount) {
        this.finalCount = finalCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<ProductImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<ProductImage> imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "finalGusses{" +
                "finalCount=" + finalCount +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", categoryId=" + categoryId +
                ", imageList=" + imageList +
                '}';
    }
}


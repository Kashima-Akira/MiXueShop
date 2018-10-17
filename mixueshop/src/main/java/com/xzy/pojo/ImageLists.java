package com.xzy.pojo;

import java.util.List;

public class ImageLists
{
    private List<DiscussImage> imageList;

    public List<DiscussImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<DiscussImage> imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "ImageLists{" +
                "imageList=" + imageList +
                '}';
    }
}

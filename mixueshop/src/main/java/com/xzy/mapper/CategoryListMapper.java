package com.xzy.mapper;


import com.xzy.pojo.*;
import com.xzy.utils.finalGusses;

import java.util.List;
import java.util.Map;

public interface CategoryListMapper
{
    //查询分类list
    public List<Product> selectAllProduct(Map map);

    //根据id查询价格
    public List<Price> price(int id);
    //照片
    public List<ProductImage> imagePath(int id);

    //查询最新商品
    public List<Product> newProduct(Map map);

    public List<List<Object>> NewImageList(Map map);
    //查询最热商品
    public List<Product> hotProduct(Map map);

    public List<List<Object>> HotImageList(Map map);

    //猜你喜欢
    public List<finalGusses> favouriteProduct(Map map);

    public List<Product> productIdResult(int pid);

    public List<Category> userCategory(String id);


    public List<Object> FavouriteImageList(Map map);



}

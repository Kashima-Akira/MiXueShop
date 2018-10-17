package com.xzy.service;


import com.xzy.pojo.*;
import com.xzy.utils.finalGusses;

import java.util.List;
import java.util.Map;

public interface CategoryListService
{
    List<Product> selectAllProduct(Map map);

    List<Product> newProduct(Map map);

    List<Product> hotProduct(Map map);






    List<Price> price(int id);

    List<ProductImage> imagePath(int id);


    List<List<finalGusses>> UserFavoutite(Map map);



    List<finalGusses> favouriteProduct(Map map);

    List<Product> productIdResult(int pid);

    List<Object> userCategory(String cid);

    List<List<Object>> NewImageList(Map map);

    List<List<Object>> HotImageList(Map map);

    List<List<Object>> FavouriteImageList(Map map);


}

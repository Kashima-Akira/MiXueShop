package com.xzy.mapper;

import com.xzy.pojo.Collect;
import com.xzy.pojo.Price;
import com.xzy.pojo.Product;
import com.xzy.pojo.ProductImage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectMapper {


    //通过商品id删除收藏(已测试)
    void deleteByPproductId(Integer id);

    //插入一条收藏(已测试)
    void insert(Collect collect) ;


    //查询收藏id
    List<String> selectId(String userid);


    //查询用户所有收藏
    List<Collect> selectAllById(String userid);

    //查询商品信息
    Product selectProdcut(Integer productid);

    //查询商品图片
    List<ProductImage> selectProductImages(String productid);

    //查询商品价格
    List<Price> selectProductPrice(String productid);

    Integer selectIds(Integer id);
}


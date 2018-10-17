package com.xzy.mapper;

import com.xzy.pojo.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ${维C果糖} on 2018/7/28.
 */

@Repository
public interface ProductMapper {
    //根据商品分类id查询商品List（通过商品购买人数降序排序）
    List<Product> getProductByBuyNumberDesc(Map map);

    //根据商品分类id查询商品List（通过商品总评分降序排序）
    List<Product> getProductByLevelDesc(Map map);

    //根据商品分类id查询商品List（通过商品更新时间降序排序）
    List<Product> getProductByUpdatedDesc(Map map);

    //根据商品分类id查询商品List（通过商品上架时间降序排序）
    List<Product> getProductByCreatedDesc(Map map);

    //推荐商品(轮播图)
    List<Product> getRecommendProduct(Integer pageNum);

    //根据商品名模糊查询商品列表
    List<Product> getProductByProductName(Map map);

    //通过商品销量查询商品列表(通过商品销量降序排序)
    List<Product> getHotSearchProduct(Integer pageNum);

}

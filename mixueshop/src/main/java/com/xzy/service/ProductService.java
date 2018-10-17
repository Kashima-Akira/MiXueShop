package com.xzy.service;

import com.xzy.pojo.Product;
import com.xzy.pojo.User;
import redis.clients.jedis.JedisCluster;
import java.util.List;
import java.util.Map;

/**
 * Created by ${维C果糖} on 2018/8/2.
 */

public interface ProductService {

    //根据商品购买人数降序排序获取商品列表
    List<Product> getProductByBuyNumberDesc(Map map);

    //根据商品总评分降序排序获取商品列表
    List<Product> getProductByLevelDesc(Map map);

    //根据商品更新时间降序排序获取商品列表
    List<Product> getProductByUpdatedDesc(Map map);

    //根据商品上架时间降序排序获取商品列表
    List<Product> getProductByCreatedDesc(Map map);

    //轮播图商品
    List<Product> getRecommendProduct(Integer pageNum);

    //根据商品名模糊查询商品列表
    List<Product> getProductByProductName(Map map);

    //查询热门搜索商品
    List<Product> getHotSearchProduct(Integer pageNum);

    //增加用户的搜索记录
    public void insertRecord(String productName, String userId) throws Exception;

    public JedisCluster getJedisClient();
}

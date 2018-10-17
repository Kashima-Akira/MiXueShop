package com.xzy.service;

import com.xzy.pojo.DiscussImage;
import com.xzy.pojo.Product;
import com.xzy.pojo.ProductDiscuss;

import java.util.List;
import java.util.Map;

public interface ProductDiscussService
{
    //插入评论
    void insertDiscuss(ProductDiscuss productDiscuss);

    //插入评论图片
    void insertDiscussImages(DiscussImage image);


    //根据订单id删除评论
    void deleteDiscussByProductId(String ordersid);


    List<ProductDiscuss> selectALL(Map map);

    //查询某用户对某订单中某商品的评论
    List<ProductDiscuss> selectDisscussByOrders(String ordersid);

    //查询某商品的总评分
    Double selectProductLevel(Integer productId);

    //更新商品评分
    void UpdateProductLevel(Integer productid);

    //查询评论条数
    Integer countDiscussService(Integer productid);

    //更新赞数量
    void upadeaeGoods(String discussId);
    //更新ordersitemSTATE
    void updateItemState(Map map);

    List<Integer> selectProductIdByordersid(String ordersid);

    List<Map> selectnameAndpath(Map resultMap);



}

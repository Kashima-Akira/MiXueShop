package com.xzy.mapper;

import com.xzy.pojo.DiscussImage;
import com.xzy.pojo.Product;
import com.xzy.pojo.ProductDiscuss;
import com.xzy.pojo.ProductImage;

import java.util.List;
import java.util.Map;

public interface ProductDiscussMapper
{
    //添加评论(已测试)
    void insertDiscuss(ProductDiscuss productdiscuss);

    //添加评论图片(已测试)
    void insertDiscussImage(DiscussImage imageList);

    //根据订单id查询用户的所有评论(已测试)
    List<ProductDiscuss> selectByOrdersid(String orderitemid);

    //查询某商品的所有评论(已测试)
    List<ProductDiscuss> selectByProductid(Map map);

    //查询评论图片（已测试）
    List<DiscussImage> selectDisscussImage(String productdiscussid);

    //根据商品订单id删除评论（已测试）
    void deleteDiscuss(String orderitemid);

    //查询评论条数（根据订单id查询）
    Integer countDiscuss(Integer productid);

    //商品评分等级查询
    Double selectLevel(Integer productid);

    //更新商品评分
    void updateProductLevel(Map map);
    //更新赞的数量
    void upadeaeGood(String discussId);
    //更新Ordersitem状态
    void updateItemState();

    void upadatestate(Map map);

    List<Integer> selectPidByordersid(String ordersid);

    List<Map> getpnameandimage(Map resultMap);



}

package com.xzy.mapper;

import com.xzy.pojo.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by css on 2018/7/23.
 */
public interface OrderMapper {
    //通过cartItem的ids获取需要提交的购物车项
    List<CartItem> getCartItemsByIds(QueryOrder queryOrder);
    //通过收货地址id获取收货地址
    SubmitAddress getSubmitAddressById(QueryOrder queryOrder);
    //通过ids删除购物车项
    void delCartItemByIds(String id);
    //插入订单项
    void insertOrderItem(OrderItem orderItem);
    //插入订单
    void insertOrders(Orders orders);
    //通过订单的ID查找订单
    Orders getOrdersById(String id);

    Orders getOrdersPartById(String id);


    //更新订单状态
    void updateOrdersState(Orders orders);

    //通过用户ID修改用户积分
    void updateUserLevel(QueryOrder queryOrder);
    //通过orderId获取该订单的价格
    BigDecimal getFinalPayByOrderId(String id);

    //通过用户ID查询用户的订单
    Long getOrdersIdByUserIdCount(String userId);

    //查询不同状态的订单id
    List<Orders> getOrdersIdListByState(QueryOrder queryOrder);


    Long getOrdersByStateCount(QueryOrder queryOrder);

    //删除订单
    void delOrders(String id);

    void updateProductNumber(Map map);

    //增加收货地址
    void insertAddress(SubmitAddress address);

    //展示收货地址
    List<SubmitAddress> getAddress(QueryOrder queryOrder);

    Long getAddressCount(String uid);

    //更新收货地址
    void deleteAddressById(SubmitAddress address);
    void updateAddressById(SubmitAddress address);


    //获取评论或未评论的商品
    List<OrderItem> getOrderItemByState(QueryOrder queryOrder);

    Long getOrderItemByStateCount(QueryOrder queryOrder);

    Price getPrice(Integer priceId);

    void updateAddress(SubmitAddress address);

    void delOrderItemByOrderId(String id);
}

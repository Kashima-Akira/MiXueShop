package com.xzy.service;

import com.xzy.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * Created by css on 2018/7/24.
 */
public interface OrderService {
    Orders insertOrders(QueryOrder queryOrder);
    void updateOrdersState(String ordersId,User user);
    Orders getOrderById(String orderId);
    List<Orders> getOrdersList(User user,int indexPage,int pageNum);
    Long getOrdersIdByUserIdCount(String userId);


    List<Orders> getOrderListByState(QueryOrder queryOrder);
    Long getOrdersByStateCount(QueryOrder queryOrder);

    void delOrders(String id);
    //void updateProductNumber(Map productId);
    //增加收货地址
    void insertAddress(SubmitAddress address);

    //展示收货地址
    List<SubmitAddress> getAddress(QueryOrder queryOrder);

    //删除收货地址
    void deleteAddressById(SubmitAddress address);

    void setAddressDefault(SubmitAddress address);
    Long getAddressCount(String uid);

    //获取评论或未评论的订单项
    List<OrderItem> getOrderItemByState(QueryOrder queryOrder);
    Long getOrderItemByStateCount(QueryOrder queryOrder);

    Orders addOrder(Integer id, Integer priceId, Integer number, User user);

    void updateAddress(SubmitAddress address);

    Orders againSubmit(String id, User user);
}

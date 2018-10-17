package com.xzy.service.serviceImp;

import com.xzy.mapper.OrderMapper;
import com.xzy.pojo.*;
import com.xzy.service.OrderService;
import com.xzy.utils.FinalPay;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by css on 2018/7/24.
 */
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    //提交订单
    @Override
    public Orders insertOrders(QueryOrder queryOrder) {
        List<CartItem> cartItems = orderMapper.getCartItemsByIds(queryOrder);
        Orders orders=new Orders();
        //order.state 0未付款，1已付款，2已评论
        //orderItem.state 1未评论，2已评论
        orders.setId(UUID.randomUUID().toString().replaceAll("-",""));
        orders.setSubmitAddressId(queryOrder.getSubmitAddressId());
        orders.setDescript(queryOrder.getDescript());
        orders.setState(0);
        orders.setUserId(queryOrder.getUser().getId());
        orders.setOrderTime(new Date());
        BigDecimal bd=new BigDecimal("0.00");
        List<OrderItem> items=new ArrayList<OrderItem>();
        for (CartItem ci : cartItems){;
            bd=bd.add(ci.getFinalPay());
            OrderItem orderItem=new OrderItem();
            orderItem.setId(UUID.randomUUID().toString().replaceAll("-",""));
            orderItem.setState(1);
            orderItem.setFinalPay(ci.getFinalPay());
            orderItem.setInsertTime(new Date());
            orderItem.setNumber(ci.getNumber());
            orderItem.setOrdersId(orders.getId());
            orderItem.setProductId(ci.getProductId());
            orderItem.setPriceId(ci.getPriceId());
            orderItem.setUserId(queryOrder.getUser().getId());
            items.add(orderItem);
            orderMapper.insertOrderItem(orderItem);
            Map<String,Object> map=new HashedMap();
            map.put("productId",ci.getProductId());
            map.put("number",ci.getNumber());
            orderMapper.updateProductNumber(map);
        }
        orders.setTotal(bd.add(new BigDecimal(queryOrder.getAddPrice())));
        Integer level=0;
        if(queryOrder.getUser().getLevel()!=null){
            level=queryOrder.getUser().getLevel();
        }

        double discount= FinalPay.getDiscount(level);
        orders.setFinalPay(bd.multiply(new BigDecimal(discount)).add(new BigDecimal(queryOrder.getAddPrice())));
        orders.setOrderItems(items);
        orderMapper.insertOrders(orders);
        for (String str : queryOrder.getCartItemIds()){
            orderMapper.delCartItemByIds(str);
        }

        return orders;
    }
    //修改订单的状态
    @Override
    public void updateOrdersState(String ordersId,User user) {
        BigDecimal finalPay=orderMapper.getFinalPayByOrderId(ordersId);
        Double v = Math.floor(finalPay.doubleValue())/10.00;
        QueryOrder queryOrder=new QueryOrder();
        queryOrder.setLevel(new Integer(v.intValue()));
        queryOrder.setUser(user);
        orderMapper.updateUserLevel(queryOrder);
        Orders orders=new Orders();
        orders.setId(ordersId);
        orders.setState(1);
        orderMapper.updateOrdersState(orders);
    }
    //通过订单ID查询订单
    @Override
    public Orders getOrderById(String orderId) {
        Orders orders = orderMapper.getOrdersById(orderId);
        return orders;
    }
    //查询所有订单
    //分页
    @Override
    public List<Orders> getOrdersList(User user,int indexPage,int pageNum) {
        QueryOrder qo=new QueryOrder();
        qo.setUser(user);
        qo.setIndexPage((indexPage-1)*pageNum);
        qo.setPageNum(pageNum);
        qo.setState(null);
        List<Orders> ordersIdList = orderMapper.getOrdersIdListByState(qo);
//        List<Orders> orderses=new ArrayList<Orders>();
//        for (Orders str : ordersIdList){
//            orderses.add(orderMapper.getOrdersPartById(str.getId()));
//        }
 //       return orderses;
        return ordersIdList;
    }

    @Override
    public Long getOrdersIdByUserIdCount(String userId) {
        return orderMapper.getOrdersIdByUserIdCount(userId);
    }

    //查询不同状态的订单
    //分页
    @Override
    public List<Orders> getOrderListByState(QueryOrder queryOrder) {
        queryOrder.setIndexPage((queryOrder.getIndexPage()-1)*queryOrder.getPageNum());
        List<Orders> ordersIdList =orderMapper.getOrdersIdListByState(queryOrder);
        return ordersIdList;
    }

    @Override
    public Long getOrdersByStateCount(QueryOrder queryOrder) {
        return orderMapper.getOrdersByStateCount(queryOrder);
    }

    //删除订单
    @Override
    public void delOrders(String id) {

        orderMapper.delOrderItemByOrderId(id);
        orderMapper.delOrders(id);
    }

//    @Override
//    public void updateProductNumber(Map productId) {
//        orderMapper.updateProductNumber(productId);
//    }

    @Override
    public void insertAddress(SubmitAddress address) {
        address.setState(1);
        orderMapper.insertAddress(address);
    }
    @Override
    public List<SubmitAddress> getAddress(QueryOrder queryOrder) {

        return orderMapper.getAddress(queryOrder);
    }

    @Override
    public void deleteAddressById(SubmitAddress address) {
        orderMapper.deleteAddressById(address);
    }

    @Override
    public void setAddressDefault(SubmitAddress address) {
        orderMapper.updateAddressById(address);
    }

    @Override
    public Long getAddressCount(String uid) {

        return orderMapper.getAddressCount(uid);
    }

    @Override
    public List<OrderItem> getOrderItemByState(QueryOrder queryOrder) {
        queryOrder.setIndexPage((queryOrder.getIndexPage()-1)*queryOrder.getPageNum());
        return orderMapper.getOrderItemByState(queryOrder);
    }

    @Override
    public Long getOrderItemByStateCount(QueryOrder queryOrder) {
        return orderMapper.getOrderItemByStateCount(queryOrder);
    }

    @Override
    public Orders addOrder(Integer id, Integer priceId, Integer number, User user) {
        Price price=orderMapper.getPrice(priceId);
        Orders orders=new Orders();
        orders.setId(UUID.randomUUID().toString().replaceAll("-",""));
        orders.setState(0);
        orders.setUserId(user.getId());
        orders.setOrderTime(new Date());
        String orderId=UUID.randomUUID().toString().replaceAll("-","");
        orders.setId(orderId);
        OrderItem orderItem=new OrderItem();
        orderItem.setId(UUID.randomUUID().toString().replaceAll("-",""));
        orderItem.setState(1);
        BigDecimal pic=price.getPrice().multiply(new BigDecimal(number+""));
        Integer level=user.getLevel();
        if(level==null){
            level=0;
        }
        orderItem.setFinalPay(pic.multiply(new BigDecimal(FinalPay.getDiscount(level))));
        orderItem.setInsertTime(new Date());
        orderItem.setNumber(number);
        orderItem.setOrdersId(orders.getId());
        orderItem.setProductId(id);
        orderItem.setPriceId(priceId);
        orderItem.setUserId(user.getId());
        orderMapper.insertOrderItem(orderItem);
        Map<String,Object> map=new HashedMap();
        map.put("productId",id);
        map.put("number",number);
        orderMapper.updateProductNumber(map);
        orders.setTotal(pic);
        orders.setFinalPay(orderItem.getFinalPay());
        List<OrderItem> li=new ArrayList<>();
        li.add(orderItem);
        orders.setOrderItems(li);
        orderMapper.insertOrders(orders);
        return orders;
    }

    @Override
    public void updateAddress(SubmitAddress address) {
        orderMapper.updateAddress(address);
    }

    @Override
    public Orders againSubmit(String id, User user) {
        Orders order = getOrderById(id);
        List<OrderItem> orderItems = order.getOrderItems();
        //order.state 0未付款，1已付款，2已评论
        //orderItem.state 1未评论，2已评论
        order.setOrderTime(new Date());
        order.setId(UUID.randomUUID().toString().replaceAll("-",""));
        order.setState(0);
        for (OrderItem oi : orderItems){
            oi.setId(UUID.randomUUID().toString().replaceAll("-",""));
            oi.setInsertTime(new Date());
            oi.setState(1);
            orderMapper.insertOrderItem(oi);
            Map<String,Object> map=new HashedMap();
            map.put("productId",oi.getProductId());
            map.put("number",oi.getNumber());
            orderMapper.updateProductNumber(map);
        }
        orderMapper.insertOrders(order);
        return order;
    }
}

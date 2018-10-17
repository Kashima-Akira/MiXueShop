package com.xzy.controller;

import com.alibaba.fastjson.JSON;
import com.xzy.common.FormToken;
import com.xzy.jedis.JedisClient;
import com.xzy.jedis.JedisClientCluster;
import com.xzy.pojo.*;
import com.xzy.service.OrderService;
import com.xzy.utils.AddOrderUtils;
import com.xzy.utils.EasyUIDataGridResult;
//import com.xzy.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by css on 2018/7/25.
 */
//购买后销量加减
@FormToken(save = true)
@Controller
public class OrdersAction {
    @Autowired
    private OrderService orderService;
    /**
     * * @param MiXueResult
    * /响应业务状态 status;
    * 响应消息 msg
    * 响应中的数据data
    */

    /**
     * 直接付款
     //* @param id(商品id)
     //* @param priceId(价格id)
     //* @param number(购买数量)
     * @return (data是Orders)
     */
    @RequestMapping("/addOrder")
    @ResponseBody
    public MiXueResult addOrder(@RequestBody AddOrderUtils addOrderUtils, HttpSession session, HttpServletRequest request){

        User user= (User)session.getAttribute("user");
        Integer id=addOrderUtils.getId();
        Integer priceId=addOrderUtils.getPriceId();
        Integer number=addOrderUtils.getNumber();
        if(user==null||id==null||priceId==null||number==null){
            System.out.println(id+"---------"+priceId+"-----"+number);
            return MiXueResult.build(0,"参数错误或未登录");
        }
        QueryOrder queryOrder=new QueryOrder();
        queryOrder.setUser(user);

        Orders  orders = orderService.addOrder(id,priceId,number,user);
        MiXueResult result = MiXueResult.ok(orders);
        return result;
    }


    /**
     * 提交订单
     * @param queryOrder(购物车项的ids,数组cartItemIds)(收货地址)
     * @return
     */
    //@FormToken(remove = true)
    @RequestMapping("/insertOrders")
    @ResponseBody
    public MiXueResult insertOrders(@RequestBody(required=false) QueryOrder queryOrder,HttpSession session, HttpServletRequest request){

        User user= (User)session.getAttribute("user");

//        {
//            user=new User();
//            user.setId("5");
//            user.setName("aaaaa");
//            user.setPassword("aaaaa");
//            user.setLevel(0);
//        }
//        {
//            List<String> ids=new ArrayList<String>();
//            ids.add("3856cd49-92d5-11e8-84a1-00163e0e74be");
//            ids.add("81dc3b32-92d5-11e8-84a1-00163e0e74be");
//            queryOrder=new QueryOrder();
//            queryOrder.setCartItemIds(ids);
//            queryOrder.setUser(user);
//        }
        if(user==null||queryOrder.getCartItemIds()==null||queryOrder.getCartItemIds().size()<1){
            return null;
        }
        queryOrder.setUser(user);
        Orders orders = orderService.insertOrders(queryOrder);
        MiXueResult result = MiXueResult.ok(orders);
        return result;
    }

    /**
     * 修改订单状态(付款)
     * @param orderId(订单id)
     * @return MiXueResult(status是1表示成功，0表示失败)
     */
    @RequestMapping("/updateOrdersState")
    @ResponseBody
    public MiXueResult updateOrdersState(@RequestBody String orderId,HttpSession session, HttpServletRequest request){
        User user= (User)session.getAttribute("user");
//        {
//            user=new User();
//            user.setId("5");
//            user.setName("aaaaa");
//            user.setPassword("aaaaa");
//            user.setLevel(0);
//            orderId="e3c17f0be1284f5fa105d82a125343e3";
//        }
        if(user==null||orderId==null||orderId.equals("")){
            return MiXueResult.build(0,"修改失败");
        }
        orderService.updateOrdersState(orderId,user);
        return MiXueResult.ok();
    }


    /**
     * 通过id查询订单
     //* @param orderId(订单id)
     * @return
     */
    @RequestMapping("getOrderById")
    @ResponseBody
    public MiXueResult getOrderById(String id,HttpSession session, HttpServletRequest request){
        User user= (User)session.getAttribute("user");
//        {
//            user=new User();
//            user.setId("aaaaa");
//            user.setName("aaaaa");
//            user.setPassword("aaaaa");
//            user.setLevel(0);
//            orderId="e3c17f0be1284f5fa105d82a125343e3";
//        }
        if(user==null||id==null||id.equals("")){
            return MiXueResult.ok();
        }
        Orders orders = orderService.getOrderById(id);
        MiXueResult result = MiXueResult.ok(orders);
        return result;
    }


    /**
     * 获取所有订单
     * @param indexPage 第几页
     //* @param pageSize 页面大小
     * @return MiXueResult(data是order的链表)
     */
    @RequestMapping("/getOrdersList")
    @ResponseBody
    public MiXueResult getOrdersList(int indexPage,HttpServletRequest request,HttpSession session){
        User user= (User)session.getAttribute("user");
//        {
//            user=new User();
//            user.setId("aaaaa");
//            user.setName("aaaaa");
//            user.setPassword("aaaaa");
//            user.setLevel(0);
//        }
        if(user==null){
            return null;
        }
        List<Orders> ordersList = orderService.getOrdersList(user,indexPage,10);

        EasyUIDataGridResult easy=new EasyUIDataGridResult();
        easy.setRows(ordersList);
        easy.setTotal(orderService.getOrdersIdByUserIdCount(user.getId()));
        MiXueResult result = MiXueResult.ok(easy);
        return result;
    }
    //查询不同状态的订单

    /**
     *
     * @param indexPage 第几页
     * @param state 0表示未付款，1表示付款的
     * @return MiXueResult(data是EasyUIDataGridResult(rows是order的链表,total是数据库中这个数据的总条数))
     */
    @RequestMapping("/getOrderListByState")
    @ResponseBody
    public MiXueResult getOrderListByState(int indexPage,Integer state,HttpServletRequest request,HttpSession session){
        User user= (User)session.getAttribute("user");
//        {
//            user=new User();
//            user.setId("aaaaa");
//            user.setName("aaaaa");
//            user.setPassword("aaaaa");
//            user.setLevel(0);
//            //state=1;
//            state=0;
//        }
        if(user==null){
            return null;
        }
        QueryOrder qo=new QueryOrder();
        qo.setState(state);
        qo.setUser(user);
        qo.setIndexPage(indexPage);
        qo.setPageNum(10);
        List<Orders> orderListByState = orderService.getOrderListByState(qo);
        EasyUIDataGridResult easy=new EasyUIDataGridResult();
        easy.setRows(orderListByState);
        easy.setTotal(orderService.getOrdersByStateCount(qo));
        MiXueResult result = MiXueResult.ok(easy);

        return result;

    }

    /**
     * 删除订单
     * @param id 删除的订单id
     * @return MiXueResult(status是1表示成功)
     */
    @RequestMapping("/delOrdersById")
    @ResponseBody
    public MiXueResult delOrders(String id,HttpServletRequest request,HttpSession session){
//        {
//            id="e3c17f0be1284f5fa105d82a125343e3";
//        }
        User user= (User)session.getAttribute("user");
        orderService.delOrders(id);
        return MiXueResult.ok();
    }



    /**
     * 增加收货地址
     * @param address(province省,city市,district县/区,street街道,post邮编,address具体地址,name收货人,telephone收货人电话)
     * @return MiXueResult(status是1)
     */
    @FormToken(remove = true)
    @RequestMapping("/insertAddress")
    @ResponseBody
    public MiXueResult insertAddress(@RequestBody(required = false) SubmitAddress address, HttpServletRequest request,HttpSession session){
        User user= (User)session.getAttribute("user");
//        {
//            user=new User();
//            user.setId("aaa");
//            address=new SubmitAddress();
//            address.setUserId("aaa");
//        }
        if(user==null||address==null){
            return MiXueResult.build(0,"未登录或未接收到信息");
        }


        address.setUserId(user.getId());
//        QueryOrder queryOrder=new QueryOrder();
//        queryOrder.setUser(user);
//        queryOrder.setIndexPage(1);
//        queryOrder.setPageNum(100);
//        List<SubmitAddress> addresss = orderService.getAddress(queryOrder);
//        if(addresss.contains(address)){
//            return MiXueResult.build(0,"地址重复");
//        }
        address.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        orderService.insertAddress(address);
        return MiXueResult.ok(address.getId());
    }

    @RequestMapping("/updateAddress")
    @ResponseBody
    public MiXueResult updateAddress(@RequestBody(required = false) SubmitAddress address, HttpServletRequest request,HttpSession session){
        User user= (User)session.getAttribute("user");
        if(user==null||address==null||address.getId()==null){
            return MiXueResult.build(0,"未登录或未接收到信息");
        }
        address.setUserId(user.getId());
        orderService.updateAddress(address);
        return MiXueResult.ok(address.getId());
    }
    /**
     * 展示收货地址
     * @param indexPage 第几页
     //* @param pageSize 页面大小
     * @return MiXueResult(data是EasyUIDataGridResult(rows是SubmitAddress的链表,total总条数))
     */
    @RequestMapping("/getAddress")
    @ResponseBody
    MiXueResult getAddress(int indexPage/*,int pageSize*/,HttpServletRequest request,HttpSession session){
        User user= (User)session.getAttribute("user");
//        {
//            user=new User();
//            user.setId("a7aaa0c7-303e-47a4-b562-b425f207c552");
//        }
        int pageSize=10;
        if(user==null){
            return MiXueResult.build(0,"未登录");
        }
        QueryOrder queryOrder=new QueryOrder();
        queryOrder.setUser(user);
        queryOrder.setIndexPage(indexPage);
        queryOrder.setPageNum(pageSize);
        List<SubmitAddress> address = orderService.getAddress(queryOrder);
        EasyUIDataGridResult easy=new EasyUIDataGridResult();
        easy.setRows(address);
        easy.setTotal(orderService.getAddressCount(user.getId()));
        return MiXueResult.ok(easy);
    }


    /**
     * 删除收货地址
     * @param addressId 收货地址的id
     * @return MiXueResult(status是1)
     */
    @RequestMapping("/deleteAddressById")
    @ResponseBody
    MiXueResult deleteAddressById(String addressId, HttpServletRequest request,HttpSession session){
        User user= (User)session.getAttribute("user");
        if (user==null||addressId==null){
            return MiXueResult.build(0,"删除失败");
        }
        SubmitAddress submitAddress = new SubmitAddress();
        submitAddress.setId(addressId);
        submitAddress.setUserId(user.getId());
        orderService.deleteAddressById(submitAddress);
        return MiXueResult.ok();
    }


    /**
     * 设置默认收货地址
     * @param id 收货地址的id
     * @return MiXueResult(status是1)
     */
    @RequestMapping("/setAddressDefault")
    @ResponseBody
    MiXueResult setAddressDefault(String id, HttpServletRequest request,HttpSession session){
        User user= (User)session.getAttribute("user");
//        {
//            user=new User();
//            user.setId("a7aaa0c7-303e-47a4-b562-b425f207c552");
//        }
        if (user==null||id==null){
            return MiXueResult.build(0,"设置失败");
        }
        SubmitAddress submitAddress = new SubmitAddress();
        submitAddress.setId(id);
        submitAddress.setUserId(user.getId());
        submitAddress.setState(2);
        orderService.setAddressDefault(submitAddress);
        return MiXueResult.ok();
    }


    /**
     *查询评论或未评论的订单
     * @param indexPage 第几页
     //* @param pageSize 页面大小
     * @param itemState 1是未评论，2是已评论
     * @return MiXueResult(EasyUIDataGridResult(rows订单项的链表,total总个数))
     */
    @RequestMapping("/getOrdersByItemState")
    @ResponseBody
    public MiXueResult getOrdersByItemState(int indexPage/*,int pageSize*/,int itemState,HttpServletRequest request,HttpSession session){
        User user= (User)session.getAttribute("user");
        int pageSize=10;
//        {
//            user=new User();
//            user.setId("a7aaa0c7-303e-47a4-b562-b425f207c552");
//        }
        if(user==null){
            return null;
        }
        QueryOrder queryOrder=new QueryOrder();
        queryOrder.setUser(user);
        queryOrder.setState(itemState);
        queryOrder.setIndexPage(indexPage);
        queryOrder.setPageNum(pageSize);
        List<OrderItem> orderItems = orderService.getOrderItemByState(queryOrder);
        EasyUIDataGridResult easy=new EasyUIDataGridResult();
        easy.setRows(orderItems);
        easy.setTotal(orderService.getOrderItemByStateCount(queryOrder));
        MiXueResult result = MiXueResult.ok(easy);
        return result;

    }

    @RequestMapping("/againSubmit")
    @ResponseBody
    public MiXueResult againSubmit(String id,HttpSession session){
        User user=(User)session.getAttribute("user");
        if(id==null||user==null||id.trim().equals("")){
            return MiXueResult.build(0,"未登录或传参错误");
        }
        Orders order= orderService.againSubmit(id,user);
        return MiXueResult.ok(order);
    }
    @RequestMapping("/getUUID")
    @ResponseBody
    public String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}

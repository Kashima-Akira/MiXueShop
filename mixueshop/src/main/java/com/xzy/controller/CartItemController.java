package com.xzy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xzy.pojo.AllCartItem;
import com.xzy.pojo.CartItem;
import com.xzy.pojo.User;
//import com.xzy.utils.SessionUtils;
import com.xzy.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author ABzzzz
 * @data 2018/7/29 10:07
 * (๑•̀ㅂ•́)و✧
 **/

@Controller

public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @RequestMapping(value = "/selectAllCartItem")
    @ResponseBody
    public List<CartItem> selectAllCartItemController(
            HttpServletRequest request,
            HttpSession session
    )
    {
        User user= (User)session.getAttribute("user");
        if (user!=null){
            String id=user.getId();
            AllCartItem allCartItem=cartItemService.selectAllCartItem(id);
            List<CartItem> all=allCartItem.getCartItemList();
            return all;
        }else {
            return null;
        }
    }

    @RequestMapping("/insertCartItem")
    @ResponseBody
    public String insertCartItemController(
            HttpServletRequest request,
            @RequestBody CartItem willcartItem,
            //productId priceId finalPay  number state
            HttpSession session
    )
    {

        User user= (User)session.getAttribute("user");
        willcartItem.setUserId(user.getId());
        if (willcartItem!=null && user!=null&&cartItemService.selectAllCartItem(user.getId()).getCartItemList().size()>34)
        {
            return "购物车已满";
        }
        else  if(null==cartItemService.selectCartItemOfUser(willcartItem))
        {
            System.out.println();
            willcartItem.setInsertTime(new Date());
            cartItemService.insertCartItem(willcartItem);
            return "已经加入购物车";
        }
        else
        {
            CartItem ctm=cartItemService.selectCartItemOfUser(willcartItem);
            System.out.println(ctm);
            Map map=new HashMap();
            map.put("id",ctm.getId());
            map.put("finalPay",ctm.getFinalPay().multiply(new BigDecimal(ctm.getNumber()+1)).divide(new BigDecimal(ctm.getNumber())));
            map.put("number",ctm.getNumber()+1);
            cartItemService.updateEachCartItemOFNumber(map);
            return "已经更新购物车";
        }


    }

    @RequestMapping("/deleteCartItem")
    @ResponseBody
    public void deleteCartItemController(
            @RequestBody Map map
    )
    {
        cartItemService.deleteCartItem(map);
    }

    @RequestMapping("/updateCartItem")
    @ResponseBody
    public void UpdateCartItemController(
            @RequestBody Map map
            // id num
    )
    {
        if (map!=null) {
            cartItemService.updateEachCartItemOFNumber(map);
        }
    }

}

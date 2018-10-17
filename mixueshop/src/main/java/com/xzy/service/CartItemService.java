package com.xzy.service;

import com.xzy.pojo.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author ABzzzz
 * @data 2018/7/29 10:02
 * (๑•̀ㅂ•́)و✧
 **/
public interface CartItemService {
    public void insertCartItem(CartItem cartItem);
    public void   deleteCartItem(Map map);
    public void updateEachCartItemOFNumber(Map map);
    public CartItem selectEachCartItem(String string);
    public Product selectCartItemProduct(String string);
    public ProductImage selectCartItemProductImage(String string);
    public AllCartItem selectAllCartItem(String string);
    public Category selectCartItemCategory(int i);
    public Price selectCartItemPrice(int i);
    public CartItem selectCartItemOfUser(CartItem cartItem);
}

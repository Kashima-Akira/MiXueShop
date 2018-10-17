package com.xzy.mapper;

import com.xzy.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * @author ABzzzz
 * @data 2018/7/23 22:02
 * (๑•̀ㅂ•́)و✧
 **/


public interface CartItemMapper {
    public void insertCartItem(CartItem CartItem);
    public void  deleteCartItem(Map map);
    public void updateEachCartItemOFNumber(Map map);
    public CartItem selectEachCartItem(String string);
    public Product selectCartItemProduct(String string);
    public AllCartItem selectAllCartItem(String string);
    public ProductImage selectCartItemProductImage(String string);
    public Category selectCartItemCategory(int i);
    public Price selectCartItemPrice(int i);
    public CartItem selectCartItemOfUser(CartItem cartItem);


}

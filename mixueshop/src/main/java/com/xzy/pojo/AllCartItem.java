package com.xzy.pojo;

import java.util.List;

/**
 * @author ABzzzz
 * @data 2018/7/25 22:25
 * (๑•̀ㅂ•́)و✧
 **/
public class AllCartItem {
    private List<CartItem> cartItemList;

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public String toString() {
        return "AllCartItem{" +
                "cartItemList=" + cartItemList +
                '}';
    }
}

package com.xzy.service.serviceImp;

import com.xzy.mapper.CartItemMapper;
import com.xzy.pojo.*;
import com.xzy.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ABzzzz
 * @data 2018/7/29 10:03
 * (๑•̀ㅂ•́)و✧
 **/
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemMapper cartItemMapper;

    @Override
    public void insertCartItem(CartItem cartItem){
        cartItemMapper.insertCartItem(cartItem);
    }
    @Override
    public void   deleteCartItem(Map map){
        cartItemMapper.deleteCartItem(map);
    };
    @Override
    public void updateEachCartItemOFNumber(Map map){
        cartItemMapper.updateEachCartItemOFNumber(map);
    };
    @Override
    public CartItem selectEachCartItem(String string){
        CartItem cartItem=cartItemMapper.selectEachCartItem(string);
        return cartItem;
    };
    @Override
    public Product selectCartItemProduct(String string){
        Product product=cartItemMapper.selectCartItemProduct(string);
        return product;
    };
    @Override
    public ProductImage selectCartItemProductImage(String string){
        ProductImage productImage=cartItemMapper.selectCartItemProductImage(string);
        return productImage;
    };
    @Override
    public AllCartItem selectAllCartItem(String string){
        AllCartItem allCartItem=cartItemMapper.selectAllCartItem(string);
        return allCartItem;
    }
    @Override
    public Category selectCartItemCategory(int i) {
        Category category=cartItemMapper.selectCartItemCategory(i);
        return category;
    }

    @Override
    public Price selectCartItemPrice(int i) {
        Price price=cartItemMapper.selectCartItemPrice(i);
        return price;
    }

    @Override
    public CartItem selectCartItemOfUser(CartItem cartItem) {
        CartItem cartItem1=cartItemMapper.selectCartItemOfUser(cartItem);
        return cartItem1;
    }
}

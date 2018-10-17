package com.xzy.service.serviceImp;

import com.xzy.mapper.ProductShowMapper;
import com.xzy.pojo.Product;
import com.xzy.pojo.UserHistory;
import com.xzy.service.ProductShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2018/7/26.
 */
@Service
public class ProductShowServiceImpl implements ProductShowService {
    @Autowired
    private ProductShowMapper productmapper;
    /*根据id取商品详情*/
    @Override
    public Product getProductDatailById(Integer id) {
        Product product=productmapper.selectProductDatailById(id);
        return product;
    }
    /*根据用户id查询商品浏览记录表*/
    @Override
    public List<UserHistory> getHistoryByUserId(String id){
        List<UserHistory> userHistories=productmapper.selectHistoryByUserId(id);
        return userHistories;
    }
    /*根据用户id和商品id查询浏览记录*/
    @Override
    public UserHistory getHistoryByUserIdAndProductId(UserHistory userHistory){
        return productmapper.selectHistoryByUserIdAndProductId(userHistory);
    }
    /*更新商品浏览历史表*/
    @Override
    public void updateHistory(UserHistory userHistory){
        productmapper.updateHistory(userHistory);
    }
    /*插入商品到浏览历史表*/
    @Override
    public void insertProductHistory(UserHistory userHistory){
        productmapper.insertHistory(userHistory);
    }

    @Override
    public void delete(Integer productId) {
        productmapper.deleteHistory(productId);
    }
    @Override
    public Integer selectStar(Integer productid) {

        return  productmapper.selectstar(productid);
    }
}
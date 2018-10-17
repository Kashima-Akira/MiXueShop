package com.xzy.service;

import com.xzy.pojo.Product;
import com.xzy.pojo.UserHistory;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2018/7/26.
 */
public interface ProductShowService {
    /*根据商品id查询商品详细表*/
    public Product getProductDatailById(Integer id);
    /*根据用户id查询商品浏览记录表*/
    public List<UserHistory> getHistoryByUserId(String id);
    /*根据用户id和商品id查询浏览记录*/
    public UserHistory getHistoryByUserIdAndProductId(UserHistory userHistory);
    /*更新商品浏览历史*/
    public void updateHistory(UserHistory userHistory);
    /*插入商品到浏览历史表*/
    public void insertProductHistory(UserHistory userHistory);

    void delete(Integer productId);
    public Integer selectStar(Integer productid);

}
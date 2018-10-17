package com.xzy.mapper;

import com.xzy.pojo.Product;
import com.xzy.pojo.UserHistory;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2018/7/25.
 */
public interface ProductShowMapper {

    /*根据商品id查询商品详细表*/
    public Product selectProductDatailById(Integer id);
    /*根据用户id查询商品浏览记录表*/
    public List<UserHistory> selectHistoryByUserId(String id);
    /*根据用户id和商品id查询浏览记录*/
    public UserHistory selectHistoryByUserIdAndProductId(UserHistory userHistory);
    /*更新商品浏览历史表*/
    public void updateHistory(UserHistory userHistory);
    /*插入商品到浏览历史表*/
    public void insertHistory(UserHistory userHistory);
    void deleteHistory(Integer productId);
    Integer selectstar(Integer productId);

}

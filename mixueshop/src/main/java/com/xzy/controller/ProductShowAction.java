package com.xzy.controller;
import com.alibaba.fastjson.JSON;
import com.xzy.jedis.JedisClientCluster;
import com.xzy.pojo.*;
import com.xzy.service.ProductShowService;
import com.xzy.service.serviceImp.ProductShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Dell on 2018/7/26.
 */
@Controller
public class ProductShowAction {
    @Autowired
    private ProductShowService productShowService;


    @Autowired
    JedisClientCluster jedis;
    /*根据id取商品详情*/
    @RequestMapping("/productDesc")
    @ResponseBody
    public Product getProductDescById(Integer id)
    {

        if(id==null||id.equals(""))
        {
            return null;
        }
        return productShowService.getProductDatailById(id);
    }

    /*插入商品到浏览历史表与将没有登录的用户浏览信息存入session中*/
    @RequestMapping("/insetHistory")
    @ResponseBody
    public MiXueResult insetHistory(Integer id, HttpSession session){
        User user = (User) session.getAttribute("user");
       if(user!=null){
           String uuid= UUID.randomUUID().toString().replace("-", "").toLowerCase();
           //User user=(User)session.getAttribute("user");

           //Product product=(Product)session.getAttribute("product");

           Set<Integer> sets=new HashSet<Integer>();
           UserHistory userHistory=new UserHistory();
           userHistory.setProductId(id);
           userHistory.setUserId(user.getId());
           UserHistory userHistory1=productShowService.getHistoryByUserIdAndProductId(userHistory);
           if(userHistory1 ==null){
               UserHistory userHistory2=new UserHistory();
               userHistory2.setId(uuid);
               userHistory2.setTime(new Date());
               userHistory2.setNumber(1);
               userHistory2.setState(1);
               userHistory2.setUserId(userHistory.getUserId());
               userHistory2.setProductId(userHistory.getProductId());
               productShowService.insertProductHistory(userHistory2);
           }else{
               userHistory1.setTime(new Date());
               Integer number = userHistory1.getNumber();
               if(number==null){
                   number=0;
               }
               userHistory1.setNumber(number+1);
               productShowService.updateHistory(userHistory1);
           }
       }
       return MiXueResult.ok();
    }

    /*查询用户浏览历史记录*/
    @RequestMapping("/selectHistory")
    @ResponseBody
    public List<HistoryMemory> selectHistory(HttpSession session){
        List<HistoryMemory> historyMemoryList=new ArrayList<HistoryMemory>();
        User user=(User)session.getAttribute("user");
        List<UserHistory> userHistories=productShowService.getHistoryByUserId(user.getId());
        for(UserHistory userHistory:userHistories)
        {
            Product product=productShowService.getProductDatailById(userHistory.getProductId());
            HistoryMemory historyMemory=new HistoryMemory();
            historyMemory.setPid(userHistory.getProductId());
            historyMemory.setUid(userHistory.getProductId().toString());
            historyMemory.setTime(historyMemory.getTime());
            historyMemory.setProduct(product);
            historyMemoryList.add(historyMemory);
        }
        return historyMemoryList;
    }


    @RequestMapping("/deleteHistory")
    @ResponseBody
    public String deleteHistory(Integer productId)
    {
        productShowService.delete(productId);
        return "yes";
    }
    @RequestMapping("/selectSTAR")
    @ResponseBody
    public Integer selectSTAR(Integer productId)
    {
        if(productShowService.selectStar(productId)==productId)
        {
            return 1;

        }else {
            return 0;
        }

    }
}
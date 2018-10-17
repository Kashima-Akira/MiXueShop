package com.xzy.controller;


import com.xzy.pojo.Product;
import com.xzy.pojo.User;
import com.xzy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by ${维C果糖} on 2018/8/5.
 */

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    //根据商品名模糊查询商品列表
    @RequestMapping("/getProductByProductName")
    @ResponseBody
    public Object getProductByProductName(String productName, Integer pageNum, HttpSession session) throws Exception{
        if (productName.contains("_")) {
            productName = productName.replaceAll("_", "");
        }
        Map map = new HashMap();
        map.put("productName", productName);
        map.put("pageNum", (pageNum-1)*10);
        User user = (User)session.getAttribute("user");
        if (user != null) {
            String userId = user.getId();
            try {
                productService.insertRecord(productName, userId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Product> productList = productService.getProductByProductName(map);
        if (productList.size() == 0) {
            if (productName.contains("吃") || productName.contains("食物")) {
                return this.getProductDescByLevel(1, 1);
            }
            if (productName.contains("喝") || productName.contains("饮品")) {
                return this.getProductDescByLevel(2, 1);
            }
            if (productName.contains("玩")) {
                return this.getProductDescByLevel(3, 1);
            }
        }
        if (productList.size() == 0) {
            return "0";
        }
        return productList;
    }

    //返回搜索记录
    @RequestMapping("/getRecord")
    @ResponseBody
    public String[] getRecord(HttpSession session) throws Exception{
        try {
            JedisCluster jedisClient = productService.getJedisClient();
            User user=(User)session.getAttribute("user");
            if (user != null && jedisClient.get(user.getId()) != null) {
                return Arrays.copyOfRange(jedisClient.get(user.getId()).split("_"), 0, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除搜索记录
    @RequestMapping("/deleteRecord")
    @ResponseBody
    public void deleteRecord(HttpSession session) throws Exception{
        try {
            JedisCluster jedisClient = productService.getJedisClient();
            User user = (User)session.getAttribute("user");
            if (user != null) {
                jedisClient.del(user.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //轮播图商品
    @RequestMapping("/getAutoRecommendProduct")
    @ResponseBody
    public List<Product> getAutoRecommendProduct(Integer pageNum) {
       if (pageNum==null)
       {
           pageNum=1;
       }
        pageNum = (pageNum-1)*12;
        List<Product> productList = productService.getRecommendProduct(pageNum);
        return productList;
    }

    //根据商品上架时间降序排序获取商品列表
    @RequestMapping("/getProductDescByCreated")
    @ResponseBody
    public List<Product> getProductDescByCreated(Integer categoryId,Integer pageNum){
        Map map = new HashMap();
        map.put("categoryId",categoryId);
        map.put("pageNum",(pageNum-1)*10);
        List<Product> productList = productService.getProductByCreatedDesc(map);
        return productList;
    }

    //根据商品购买人数降序排序获取商品列表
    @RequestMapping("/getProductDescByBuyNumber")
    @ResponseBody
    public List<Product> getProductDescByBuyNumber(Integer categoryId,Integer pageNum){
        Map map = new HashMap();
        map.put("categoryId",categoryId);
        map.put("pageNum",(pageNum-1)*10);
        List<Product> productList= productService.getProductByBuyNumberDesc(map);
        return productList;
    }

    //根据商品总评分降序排序获取商品列表
    @RequestMapping("/getProductDescByLevel")
    @ResponseBody
    public List<Product> getProductDescByLevel(Integer categoryId,Integer pageNum){
        Map map = new HashMap();
        map.put("categoryId",categoryId);
        map.put("pageNum",(pageNum-1)*10);
        List<Product> productList = productService.getProductByLevelDesc(map);
        return productList;
    }

    //根据商品更新时间降序排序获取商品列表
    @RequestMapping("/getProductDescByUpdated")
    @ResponseBody
    public List<Product> getProductDescByUpdated(Integer categoryId,Integer pageNum){
        Map map = new HashMap();
        map.put("categoryId",categoryId);
        map.put("pageNum",(pageNum-1)*10);
        List<Product> productList = productService.getProductByUpdatedDesc(map);
        return productList;
    }

    //获得热门搜索商品
    @RequestMapping("/getHotSearchProduct")
    @ResponseBody
    public List<Product> getHotSearchProduct(Integer pageNum) {
        if (pageNum==null)
        {
            pageNum=1;
        }
        pageNum = (pageNum-1)*5;
        List<Product> productList = productService.getHotSearchProduct(pageNum);
        return productList;
    }

}

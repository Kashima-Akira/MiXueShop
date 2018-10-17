package com.xzy.controller;

import com.xzy.pojo.Collect;
import com.xzy.pojo.Product;
import com.xzy.pojo.User;
import com.xzy.service.CollectService;
import com.xzy.service.ProductShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
public class CollectController
{
    @Autowired
    private CollectService collectService;
    @Autowired
    private ProductShowService productShowService;

    @RequestMapping("/insertCollectionController")
    @ResponseBody
    public String insertCollectionController(Integer productId, HttpSession session)
    {
        if(productId==null)
        {
            return "productid is null";
        }
        if(collectService.selectID(productId)==productId)
            return "商品已存在";
        User user=(User)session.getAttribute("user");


        //调用productshowservice查询商品详情
        Product product=productShowService.getProductDatailById(productId);

        Collect collect=new Collect();
        //插入收藏表中
        collect.setDescript(product.getDescript());
        collect.setUserId(user.getId());
        collect.setProductId(product.getId());
        collect.setCollectTime(new Date());
        //collect.setId("666");
        collect.setId(UUID.randomUUID().toString());
        collect.setState(product.getState());
        collectService.insertCollection(collect);

        return "ok";
    }
    @RequestMapping("/selectCollectionController")
    @ResponseBody
    public List<Collect> selectCollection(HttpSession session)
    {
        User user=(User)session.getAttribute("user");

        List<Collect> list=collectService.selectCollection(user.getId());
       // List<Collect> list=collectService.selectCollection("1");
        return list;
    }

    @RequestMapping("/deleteCollectionController")
    @ResponseBody
    public String deleteCollectionController(Integer productid)
    {

        System.out.println(productid);
//        //collectService.deleteCollection(101);
       collectService.deleteCollection(productid);
        return "index.jsp";
    }
}

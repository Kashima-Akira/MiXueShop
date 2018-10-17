package com.xzy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.mapper.CategoryListMapper;
import com.xzy.pojo.*;
import com.xzy.service.CategoryListService;
import com.xzy.utils.finalGusses;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.util.*;

/**
 * Created by ♕ Prince on 2018/7/30.
 */
@Controller
public class CategoryListController
{
    @Autowired
    private CategoryListService categoryListService;
    @RequestMapping(value = "/selectAllProduct")


    @ResponseBody
    public List<Product> selectAllProduct(@RequestParam("pageNum")int pageNum,@RequestParam("cid")int cid)
    {
        Map map=new HashMap();
        map.put("cid",cid);
        map.put("pageNum",pageNum*10);
        map.put("pageSize",10);
        List list=categoryListService.selectAllProduct(map);
        return list;
    }


    @RequestMapping(value = "/newProduct")
    @ResponseBody
    public List<Product> newProduct(@RequestParam("pageNum")int pageNum)
    {
        Map  map=new HashMap();
        map.put("pageNum",pageNum*10);
        map.put("pageSize",10);
        List list=categoryListService.newProduct(map);
        return list;
    }

    @RequestMapping(value = "/hotProduct")
    @ResponseBody
    public List<Product> hotProduct(@RequestParam("pageNum")int pageNum)
    {
        Map map=new HashMap();
        map.put("pageNum",pageNum*10);
        map.put("pageSize",10);
        List list=categoryListService.hotProduct(map);

        return list;
    }

    @RequestMapping(value = "/favouriteProduct")
    @ResponseBody
    public List<finalGusses> favouriteProduct()
    {
        Map map=new HashMap();

        List <finalGusses> list=categoryListService.favouriteProduct(map);
        return list;
    }

    @RequestMapping(value = "/UserFavoutite")
    @ResponseBody
    public List<List<finalGusses>> UserFavoutite(@RequestParam("cid")int cid ,@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")Integer pageSize)
    {

        Map map=new HashMap();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("cid",cid);
        return categoryListService.UserFavoutite(map);

    }
    @RequestMapping(value = "/HotImageList")
    @ResponseBody
    public List<Product> HotImageList(@RequestParam("pageNum")int pageNum)
    {
        Map map=new HashMap();
        map.put("pageNum",pageNum*2);
        map.put("pageSize",2);
        List list=categoryListService.HotImageList(map);

        return list;
    }

    @RequestMapping(value = "/NewImageList")
    @ResponseBody
    public List<Product> NewImageList(@RequestParam("pageNum")int pageNum)
    {
        Map  map=new HashMap();
        map.put("pageNum",pageNum*2);
        map.put("pageSize",2);
        List list=categoryListService.NewImageList(map);
        return list;
    }

    @RequestMapping(value = "/FavouriteImageList")

    @ResponseBody

    public MiXueResult FavouriteImageList(HttpSession session, Integer pageNum)
    {

        User user=(User) session.getAttribute("user");
        Map map = null;
        if(user!=null)
        {
            map=new HashMap();
            map.put("pageNum", pageNum*3);
            map.put("pageSize", 3);
            map.put("uname", user.getId());
            return MiXueResult.ok(categoryListService.FavouriteImageList(map));
        }
        else
        {
            map = new HashMap();
            map.put("pageNum", pageNum*3);
            map.put("pageSize", 3);
            return MiXueResult.ok(categoryListService.HotImageList(map));
        }
    }

    @RequestMapping("/userCategory")
    @ResponseBody
    public List<Object> userCategory(@RequestParam("cid") String cid)
    {
        return categoryListService.userCategory(cid);

    }


    @RequestMapping("getUserId")

    @ResponseBody

    public String getUserId(HttpSession session)

    {

        User user=(User) session.getAttribute("user");
        if(user==null)
        {
            System.out.println("User================================================NULL!!!!111111111111111111111");
            return null;
        }
        return user.getId();

    }

}

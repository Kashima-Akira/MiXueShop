package com.xzy.service.serviceImp;


import com.xzy.mapper.CategoryListMapper;
import com.xzy.pojo.*;
import com.xzy.service.CategoryListService;
import com.xzy.utils.finalGusses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Created by ♕ Prince on 2018/7/31.
 */
@Service
public class CategoryListServiceImp implements CategoryListService
{

    @Autowired
    private CategoryListMapper categoryListMapper;


    @Override
    public List<Product> selectAllProduct(Map map)
    {

        List<Product> list= categoryListMapper.selectAllProduct(map);

        return list;
    }

    @Override
    public List<Product> newProduct(Map map) {
        return categoryListMapper.newProduct(map);
    }

    @Override
    public List<Product> hotProduct(Map map) {
        return categoryListMapper.hotProduct(map);
    }

    @Override
    public List<finalGusses> favouriteProduct(Map map)
    {

        return categoryListMapper.favouriteProduct(map);


    }





    @Override
    public List<Price> price(int id) {
        return categoryListMapper.price(id);
    }

    @Override
    public List<ProductImage> imagePath(int id) {
        return categoryListMapper.imagePath(id);
    }

    @Override
    public List<Product> productIdResult(int pid) {
        return categoryListMapper.productIdResult(pid);
    }

    @Override
    public List<Object> userCategory(String cid)
    {

        List list=categoryListMapper.userCategory(cid);
        Iterator<Map> iterator=list.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next().get("id"));
        }
        return list;


    }

    @Override
    public List<List<Object>> NewImageList(Map map) {
        return categoryListMapper.NewImageList(map);
    }

    @Override
    public List<List<Object>> HotImageList(Map map) {
        return categoryListMapper.HotImageList(map);
    }

    @Override
    public List<List<Object>> FavouriteImageList(Map map)

    {


        List list=categoryListMapper.userCategory((String) map.get("uname"));
        List<List<Object>> favList=new ArrayList<List<Object>>();


        Iterator<Map> it=list.iterator();
        while(it.hasNext())
        {

            Integer id= (Integer) it.next().get("id");
            System.out.println("id="+id);

            map.put("pageNum",map.get("pageNum"));
            map.put("pageSize",3);

            map.put("id",id);
            favList.add(categoryListMapper.FavouriteImageList(map));

        }
        System.out.println("fav---------------"+favList.toString());
        int count=0;
        Iterator<List<Object>> ita=favList.iterator();

        while(ita.hasNext())
        {
            List<Object> next = ita.next();
            count+=next.size();
            System.out.println(count+"count");
        }
        if(count<3)
        {
            Map map1=new HashMap();
            map1.put("pageNum",map.get("pageNum"));
            map1.put("pageSize",3);
            return categoryListMapper.HotImageList(map1);
        }
        return favList;

    }


    @Override
    public List<List<finalGusses>> UserFavoutite(Map map)
    {

        List<Category> list=categoryListMapper.userCategory((String)map.get("cid"));
        List<List<finalGusses>> favList=new ArrayList<List<finalGusses>>();
        map=new HashMap();
        map.put("pageNum",map.get("pageNum"));
        map.put("pageSize",10);
        map.put("id",map.get("id"));
        Iterator<Category> it=list.iterator();
        while(it.hasNext())
        {
            Category category = it.next();
            favList.add(categoryListMapper.favouriteProduct(map));
        }

        return favList;

    }
}






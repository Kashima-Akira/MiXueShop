package com.xzy.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.mapper.ProductDiscussMapper;
import com.xzy.pojo.DiscussImage;
import com.xzy.pojo.Product;
import com.xzy.pojo.ProductDiscuss;
import com.xzy.service.ProductDiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductDiscussServiceImp implements ProductDiscussService {

    @Autowired
    private ProductDiscussMapper productDiscussMapper;

    @Override
    public void insertDiscuss(ProductDiscuss productDiscuss) {

        productDiscussMapper.insertDiscuss(productDiscuss);
    }

    @Override
    public void insertDiscussImages(DiscussImage image) {
        productDiscussMapper.insertDiscussImage(image);
    }

    @Override
    public void deleteDiscussByProductId(String productid) {
        productDiscussMapper.deleteDiscuss(productid);
    }


    @Override
    public List<ProductDiscuss> selectALL(Map map)
    {
        List<ProductDiscuss> productDiscusses=productDiscussMapper.selectByProductid(map);
        return productDiscusses;

    }

    @Override
    public List<ProductDiscuss> selectDisscussByOrders(String ordersid) {
        List<ProductDiscuss> list=productDiscussMapper.selectByOrdersid(ordersid);
        return list;
    }

    @Override
    public Double selectProductLevel(Integer productid)
    {
        Double level=productDiscussMapper.selectLevel(productid);

        return level;
    }

    @Override
    public void UpdateProductLevel(Integer productid)
    {
        Double level=selectProductLevel(productid);

        Integer levelInt=level.intValue();
        Map map=new HashMap();
        map.put("level",levelInt);
        map.put("id",productid);
        productDiscussMapper.updateProductLevel(map);

    }

    @Override
    public Integer countDiscussService(Integer productid) {
        return productDiscussMapper.countDiscuss(productid);
    }

    @Override
    public void upadeaeGoods(String discussId) {
        productDiscussMapper.upadeaeGood(discussId);
    }

    @Override
    public void updateItemState(Map map) {
        productDiscussMapper.upadatestate(map);
    }


    @Override
    public List<Integer> selectProductIdByordersid(String ordersid)
    {

        return productDiscussMapper.selectPidByordersid(ordersid);
    }

    @Override
    public List<Map> selectnameAndpath(Map resultMap) {

        return  productDiscussMapper.getpnameandimage(resultMap);
    }


}


package com.xzy.service.serviceImp;

import com.xzy.mapper.CollectMapper;
import com.xzy.pojo.Collect;
import com.xzy.pojo.Orders;
import com.xzy.pojo.Product;
import com.xzy.pojo.User;
import com.xzy.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CollectServiceImp implements CollectService
{
    @Autowired
    private CollectMapper collectMapper;

    //插入收藏
    @Override
    public Collect insertCollection(Collect collect)
    {

        collectMapper.insert(collect);

        return collect;
    }

    @Override
    public void deleteCollection(Integer productid)
    {
        collectMapper.deleteByPproductId(productid);
    }

    @Override
    public List<Collect> selectCollection(String userId)
    {
        List<Collect> list= collectMapper.selectAllById(userId);
        return list;
    }

    @Override
    public Integer selectID(Integer ID){
        return collectMapper.selectIds(ID);
    }
}

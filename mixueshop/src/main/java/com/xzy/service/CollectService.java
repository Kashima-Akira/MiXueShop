package com.xzy.service;

import com.xzy.pojo.Collect;
import com.xzy.pojo.Product;
import com.xzy.pojo.User;

import java.util.List;


public interface CollectService
{
    Collect insertCollection(Collect collect);
    void deleteCollection(Integer productid);
    List<Collect> selectCollection(String userId);

    Integer selectID(Integer ID);

}

package com.xzy.service.serviceImp;

import com.xzy.mapper.ProductMapper;
import com.xzy.pojo.*;
import com.xzy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ScanResult;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by ${维C果糖} on 2018/8/2.
 */

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductByProductName(Map map) {
        List<Product> products = productMapper.getProductByProductName(map);
        return products;
    }

    @Override
    public List<Product> getProductByCreatedDesc(Map map) {
        List<Product> products = productMapper.getProductByCreatedDesc(map);
        return products;
    }

    @Override
    public List<Product> getProductByBuyNumberDesc(Map map) {
        List<Product> products = productMapper.getProductByBuyNumberDesc(map);
        return products;
    }

    @Override
    public List<Product> getProductByLevelDesc(Map map) {
        List<Product> products = productMapper.getProductByLevelDesc(map);
        return products;
    }

    @Override
    public List<Product> getProductByUpdatedDesc(Map map) {
        List<Product> products = productMapper.getProductByUpdatedDesc(map);
        return products;
    }

    @Override
    public List<Product> getRecommendProduct(Integer pageNum) {
        List<Product> products = productMapper.getRecommendProduct(pageNum);
        return products;
    }

    @Override
    public List<Product> getHotSearchProduct(Integer pageNum) {
        List<Product> products = productMapper.getHotSearchProduct(pageNum);
        return products;
    }

    @Override
    //增加搜索记录
    public void insertRecord(String productName, String userId) throws Exception {
        JedisCluster jedisClient = this.getJedisClient();
        if (productName == null) {
            return ;
        }
        try {
            if (jedisClient.get(userId) == null) {
                jedisClient.set(userId, "");
            }
            String str = jedisClient.get(userId);
            String[] strings = str.split("_");
            for (int i = 0; i < strings.length; i++) {
                if (productName.equals(strings[i])) {
                    if (strings.length == 1) {
                        str = "";
                    } else {
                        for (int j = i; j < strings.length - 1; j++) {
                            strings[j] = strings[j + 1];
                        }
                        str = strings[0];
                        for (int x = 1; x < strings.length - 1; x++) {
                            str = str + "_" + strings[x];
                        }
                    }
                }
            }
            str = productName + "_" + str;
            if (str.endsWith("_")) {
                str = productName;
            }
            jedisClient.set(userId, str);
            if (jedisClient.get(userId).split("_").length > 10) {
                jedisClient.set(userId,
                        org.apache.commons.lang3.StringUtils.substringBeforeLast(jedisClient.get(userId), "_"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public JedisCluster getJedisClient() {
        JedisPoolConfig config = new JedisPoolConfig();
        config =new JedisPoolConfig();
        config.setMaxTotal(60000);//设置最大连接数
        config.setMaxIdle(1000); //设置最大空闲数
        config.setMaxWaitMillis(3000);//设置超时时间
        config.setTestOnBorrow(true);
        // 集群结点
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("47.95.249.186", Integer.parseInt("7001")));
        jedisClusterNode.add(new HostAndPort("47.95.249.186", Integer.parseInt("7002")));
        jedisClusterNode.add(new HostAndPort("47.95.249.186", Integer.parseInt("7003")));
        jedisClusterNode.add(new HostAndPort("47.95.249.186", Integer.parseInt("7004")));
        jedisClusterNode.add(new HostAndPort("47.95.249.186", Integer.parseInt("7005")));
        jedisClusterNode.add(new HostAndPort("47.95.249.186", Integer.parseInt("7006")));
        return new JedisCluster(jedisClusterNode, config);
    }
}

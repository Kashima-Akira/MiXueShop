import com.xzy.mapper.CategoryListMapper;
import com.xzy.mapper.OrderMapper;
import com.xzy.pojo.Orders;
import com.xzy.pojo.QueryOrder;
import com.xzy.pojo.SubmitAddress;
import com.xzy.pojo.User;
import com.xzy.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by css on 2018/8/12.
 */
public class CategoryListTest
{
    @Test
    public void test1()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-redis.xml"});
        OrderMapper bean = applicationContext.getBean(OrderMapper.class);
        SubmitAddress submitAddress = new SubmitAddress();
        submitAddress.setId(UUID.randomUUID().toString().replaceAll("-",""));
        submitAddress.setUserId("a7aaa0c7-303e-47a4-b562-b425f207c552");
        submitAddress.setProvince("aaaaaaaaaaaaaaa");
        bean.insertAddress(submitAddress);
        //Orders ordersById = bean.getOrdersById("184dc432c6d947e89d63f92cf48982ee");
        //System.out.println(ordersById);
        //Orders orderListByState = bean.getOrdersPartById("e8beb446ec944516bd19c23abd5e1917");
        //System.out.println(orderListByState);

    }
}

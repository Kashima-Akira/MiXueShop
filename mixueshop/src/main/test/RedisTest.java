import com.xzy.jedis.JedisClient;
//import com.xzy.utils.SessionUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by css on 2018/8/13.
 */
public class RedisTest {
    @Test
    public void jedisClientPool(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext-redis.xml");
        JedisClient jedisClient = applicationContext.getBean(JedisClient.class);

        System.out.println(jedisClient.get("lalalalalalalalal"));
        jedisClient.set("jedisTest","client");
        String test = jedisClient.get("jedisTest");
        System.out.println(test);
    }
//    @Test
//    public void sessionUtils(){
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
//        SessionUtils jedisClient = applicationContext.getBean(SessionUtils.class);
//
//        System.out.println(jedisClient.getJedis());
//        System.out.println(jedisClient);
//    }
}

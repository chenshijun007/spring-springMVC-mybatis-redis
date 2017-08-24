
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * Created by csj on 2017/8/17.
 */
public class test {

    private static ApplicationContext applicationContext;

    static {
        applicationContext=new ClassPathXmlApplicationContext("spring/spring-core.xml");
    }

    @Test
    public void testApplicationContext(){
        System.out.println(applicationContext);

        RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
        ValueOperations<String, String> stringOperations = redisTemplate
                .opsForValue();
          stringOperations.set("age","123",20,TimeUnit.SECONDS);
         Boolean f=stringOperations.setIfAbsent("age","123");
         String age= stringOperations.get("age");

        System.out.println(f);
        System.out.println(age);
    }
}

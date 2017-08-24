package com.hanboard.util;


import com.hanboard.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionCommands;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by csj on 2017/8/18.
 */

@Component
public class RedisUtil {

    private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    private static RedisTemplate redisTemplate;


    // private final static RedisUtil instance = new RedisUtil();

    private RedisUtil() {
    }

  /*  public static RedisUtil redisInstance() {
        return instance;
    }*/

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }


    /**
     * 添加字符串缓存
     *
     * @param key   键名称
     * @param value 字符串的值
     * @param time  缓存保存时间长度
     * @param type  保存时间类型 type 可选 天，小时，分钟，秒
     */
    public static void saveCache(String key, String value, long time, TimeUnit type) {
        try {
            redisTemplate.opsForValue().set(key, value, time, type);
        } catch (Exception e) {
            logger.error("带时间的字符串添加失败!" + e.getMessage());
            throw new RedisException("添加redis缓存失败!");

        }
    }

    /**
     * 添加字符串缓存 默认永久保存
     *
     * @param key   键名称
     * @param value 字符串的值
     */
    public static void saveCache(String key, String value) {
        try {
       // redisTemplate.boundValueOps("KE:"+1111).set("WODE");
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            logger.error("字符串添加失败!" + e.getMessage());
            throw new RedisException("添加redis缓存失败!");
        }
    }

    /**
     * 添加整形数据
     *
     * @param key   键名称
     * @param value 数字
     * @param time  缓存保存时间长度
     * @param type  保存时间类型 type 可选 天，小时，分钟，秒
     */
    public static void saveCache(String key, Integer value, long time, TimeUnit type) {
        try {
            redisTemplate.opsForValue().set(key, value, time, type);
        } catch (Exception e) {
            logger.error("带时间的数字添加失败!" + e.getMessage());
            throw new RedisException("添加redis缓存失败!");
        }
    }

    /**
     * 添加整形数据 永久保存
     *
     * @param key   键名称
     * @param value 数字
     */
    public static void saveCache(String key, Integer value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            logger.error("数字添加失败!" + e.getMessage());
            throw new RedisException("添加redis缓存失败!");
        }
    }

    /**
     * 添加long 类型数据 永久保存
     *
     * @param key   键名称
     * @param value 数字
     */
    public static void saveCache(String key, long value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            logger.error("数字添加失败!" + e.getMessage());
            throw new RedisException("添加redis缓存失败!");
        }
    }


    /**
     * 添加long 类型数据
     *
     * @param key
     * @param value
     * @param time
     * @param type  可选 天，小时，分钟，秒
     */
    public static void saveCache(String key, long value, long time, TimeUnit type) {
        try {
            redisTemplate.opsForValue().set(key, value, time, type);
        } catch (Exception e) {
            logger.error("数字添加失败!" + e.getMessage());
            throw new RedisException("添加redis缓存失败!");
        }
    }

    /**
     * 永久保存对象
     *
     * @param key
     * @param object 可以是List，也可以是单个object
     */
    public static void saveCache(String key, Object object) {
        try {
            redisTemplate.opsForValue().set(key, object);
        } catch (Exception e) {
            logger.error("永久保存对象失败!" + e.getMessage());
            throw new RedisException("添加redis缓存失败!");
        }
    }

    /**
     * 保存带时间的对象
     *
     * @param key
     * @param object 可以是List，也可以是单个object
     * @param time
     * @param type   可选 天，小时，分钟，秒
     */
    public static void saveCache(String key, Object object, long time, TimeUnit type) {
        try {
            redisTemplate.opsForValue().set(key, object, time, type);
        } catch (Exception e) {
            logger.error("带时间保存对象失败！" + e.getMessage());
            throw new RedisException("添加redis缓存失败!");
        }
    }

    /**
     * 获取字符串
     * @param key
     * @return
     */
    public static  String  getCache(String key){
      return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取缓存实体
     *
     * @param key    键
     * @param tClass
     * @param <T>    实体
     * @return
     */
    public static <T> T getCache(String key, Class<T> tClass) {
        T object = null;
        try {
            object = (T) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error("获取对象失败！" + e.getMessage());
            throw new RedisException("获取redis缓存失败!");
        }
        return object;
    }

    /**
     * 获取缓存List<T>
     *
     * @param key
     * @param tClass
     * @param <T>    实体
     * @return
     */
    public static <T> List<T> getCacheList(String key, Class<T> tClass) {

        List<T> object = null;
        try {
            object = (List<T>) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取list失败！" + "key:" + key);
            throw new RedisException("获取edis缓存失败!");
        }
        return object;
    }


    /**
     * 删除单个缓存
     *
     * @param key 键
     */
    public static void deleteCache(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除缓存
     *
     * @param key 键
     */
    public static void deleteCache(List<String> key) {
        redisTemplate.delete(key);
    }


}

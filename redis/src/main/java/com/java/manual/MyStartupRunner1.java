package com.java.manual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 服务启动加载数据
 * Created by Administrator on 2017/8/8 0008.
 */
@Component
public class MyStartupRunner1 implements CommandLineRunner{

    @Autowired
    JedisPool jedisPool;
    @Override
    public void run(String... strings) throws Exception {
        Jedis jedis= jedisPool.getResource();
        try {
            jedis.psubscribe(new Subscribe(), new String[]{"user/actives/*" , "order/actives/*" , "product/actives/*"});
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        }finally {
            jedis.close();
        }
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
    }
}

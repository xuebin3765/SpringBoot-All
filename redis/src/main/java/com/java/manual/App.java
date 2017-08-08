package com.java.manual;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class App {

    @Test
    public void testRedis() {
        try {
            Jedis jr = new Jedis("localhost",6379); //redis服务地址和端口号
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type" , "type");
            jsonObject.put("id" , 10);
            jsonObject.put("number" , 30);
            jr.publish("user/actives/add" , jsonObject.toJSONString());




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

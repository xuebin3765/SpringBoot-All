package com.java.manual;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.net.InetAddress;

/**
 *  spring boot 入口
 * Created by Administrator on 2017/8/8 0008.
 */
@SpringBootApplication
public class SpringBootRedisApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootRedisApplication.class);

    public static void main(String args[]) throws Exception{

        SpringApplication app = new SpringApplication(SpringBootRedisApplication.class);
        Environment environment = app.run(args).getEnvironment();

        LOG.info("Access URLs:\n----------------------------------------------------------\n\t" +
                        "Local: \t\t http://127.0.0.1:{} \n\t" +
                        "External: \t http://{}:{} \n----------------------------------------------------------",
                environment.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                environment.getProperty("server.port"));
    }
}

package com.example.sbmp.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lengleng
 * @since 2017-08-19
 */
@SuppressWarnings("unused")
@RestController
public class IndexController {
    private static final int LIMIT = 2;
    private static final long TIMEOUT = 1000L;

    private static JedisPool jedisPool;

    @Autowired
    public IndexController(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @GetMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        Jedis jedis = jedisPool.getResource();
        String token = RedisRateLimiter.acquireTokenFromBucket(jedis, LIMIT, TIMEOUT);
        if (token == null) {
            response.sendError(500);
        }
        jedisPool.returnResource(jedis);
    }

}

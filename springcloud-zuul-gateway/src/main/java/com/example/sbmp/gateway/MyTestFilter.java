package com.example.sbmp.gateway;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * @email wangiegie@gmail.com
 * @data 2017-08
 */
@Component
public class MyTestFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("--------------------------------->");
        return null;
    }
}

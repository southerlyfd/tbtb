package com.tbtaobao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author ：taoyl
 * @date ：Created in 2020-05-21 21:25
 * @description：
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulMain {

    public static void main(String[] args) {
        SpringApplication.run(ZuulMain.class, args);
    }

}
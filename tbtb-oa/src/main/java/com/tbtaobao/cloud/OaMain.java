package com.tbtaobao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：jhb
 * @date ：2020-04-12 21:46
 */
@SpringBootApplication
@EnableEurekaClient
public class OaMain {

    public static void main(String[] args) {
        SpringApplication.run(OaMain.class, args);
    }
}

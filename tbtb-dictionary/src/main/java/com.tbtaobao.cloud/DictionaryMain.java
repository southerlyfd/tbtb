package com.tbtaobao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：taoyl
 * @date ：Created in 2020-05-28 20:11
 * @description：
 */
@SpringBootApplication
@EnableEurekaClient
public class DictionaryMain {

    public static void main(String[] args) {
        SpringApplication.run(DictionaryMain.class, args);
    }
}

package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.baizhi.dao")
@EnableEurekaClient
@EnableFeignClients
public class Order {

    public static void main(String[] args) {
        SpringApplication.run(Order.class, args);
    }

}

package com.atguigu.gulimail.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.gulimail.product.dao")
public class GulimailProductApplication {

    public static void main(String[] args) {

        SpringApplication.run(GulimailProductApplication.class, args);
    }

}

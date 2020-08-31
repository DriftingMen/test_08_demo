package com.drift;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.drift.dao"})
public class Test08DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test08DemoApplication.class, args);
    }

}

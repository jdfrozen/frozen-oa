package com.frozen.frozenoa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.frozen.*.dao")
@ComponentScan({"com.frozen.frozenoa.*"})
public class FrozenOaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrozenOaApplication.class, args);
    }

}


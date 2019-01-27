package com.frozen.frozenoa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.frozen.*.dao")
public class FrozenOaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrozenOaApplication.class, args);
    }

}


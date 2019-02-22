package com.onlineanswer.hc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.onlineanswer.hc.*.dao")
public class AnswerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnswerApplication.class, args);
    }

}


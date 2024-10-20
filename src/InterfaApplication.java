package com.example.interfa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.interfa.entity")
public class InterfaApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterfaApplication.class, args);
    }

}
// taskkill /f /t /im java.exe

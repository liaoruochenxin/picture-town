package com.xj.imageback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xj.imageback.mapper")
public class ImageBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageBackApplication.class, args);
    }

}

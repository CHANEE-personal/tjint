package com.tjint.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@MapperScan(basePackages = "com.tjint.mapper")
@ComponentScans({
        @ComponentScan(basePackages = "com.tjint")
})
@SpringBootApplication(scanBasePackages = "com", exclude = SecurityAutoConfiguration.class)
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}

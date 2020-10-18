package com.terrychan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignOrder8000 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignOrder8000.class,args);
    }

}

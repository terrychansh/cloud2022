package com.terrychan.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.terrychan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_hanlder")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){

        String result=paymentService.paymentInfo_ok(id);
        log.info("...paymentInfo_ok--result:"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String paymentInfo_timeout(@PathVariable("id") Integer id){

        String result=paymentService.paymentInfo_timeout(id);
        log.info("...paymentInfo_ok--result:"+result);
        return result;
    }

    public String paymentInfo_timeout_hanlder(@PathVariable("id") Integer id){

        String result=paymentService.paymentInfo_timeout(id);
        log.info("...paymentInfo_ok--result:"+result);
        return result;
    }
    public String payment_global_hanlder(){

         log.info("...paymentInfo_ok--result:payment_global_hanlder");
        return "global";
    }
}

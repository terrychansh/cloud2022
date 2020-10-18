package com.terrychan.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()
                +" paymentInfo_ok,id: "+id+"\t"+"哈哈";
    }

    @HystrixCommand(fallbackMethod ="paymentInfo_timeoutHandler",commandProperties = @HystrixProperty(name
    ="execution.isolation.thread.timeoutInMilliseconds",value = "3000"))
    public String paymentInfo_timeout(Integer id){

        int time=3;
        try{
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return "线程池："+Thread.currentThread().getName()
                +" paymentInfo_timeout,id: "+id+"\t"+"哈哈,耗时3秒钟";
    }

    public String paymentInfo_timeoutHandler(Integer id){


        return "线程池："+Thread.currentThread().getName()
                +" paymentInfo_timeout_handler,id: "+id+"\t"+"哈哈,耗时3秒钟,服务降级";
    }
}

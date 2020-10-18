package com.terrychan.springcloud.controller;

import com.terrychan.springcloud.entities.CommonResult;
import com.terrychan.springcloud.entities.Payment;
import com.terrychan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort ;
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果是："+result);
        if (result >0){
            return new CommonResult(200,"插入数据库成功"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库成功"+serverPort,result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){

        log.info("id:"+id);
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果是："+payment);
        if (payment !=null){
            return new CommonResult(200,"查询成功,服务器："+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录"+serverPort,null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> service =discoveryClient.getServices();
        for (String element : service){
            log.info("****elemment:"+element);
        }
        List<ServiceInstance> instances= discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for (ServiceInstance instance :instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}

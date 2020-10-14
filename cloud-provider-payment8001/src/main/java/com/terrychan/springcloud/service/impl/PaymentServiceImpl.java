package com.terrychan.springcloud.service.impl;

import com.terrychan.springcloud.dao.PaymentDao;
import com.terrychan.springcloud.entities.Payment;
import com.terrychan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    @Override
    public Payment getPaymentById(Long id){
        log.info("id:"+id);
        return paymentDao.getPaymentById(id);
    }
}

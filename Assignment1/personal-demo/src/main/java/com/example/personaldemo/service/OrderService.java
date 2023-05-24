package com.example.personaldemo.service;

import com.example.personaldemo.entity.Order;
import com.example.personaldemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public int save_order(Order order){
        return orderMapper.save_order(order);
    }
}

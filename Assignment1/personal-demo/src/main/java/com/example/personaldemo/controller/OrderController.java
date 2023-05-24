package com.example.personaldemo.controller;

import com.example.personaldemo.entity.Order;
import com.example.personaldemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Create")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/CreateOrder")
    public Integer save_order(@RequestBody Order order)
    { return orderService.save_order(order); }
}
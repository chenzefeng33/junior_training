package com.test.controller;

import com.test.entity.Order;
import com.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Create")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/CreateOrder")
    @CrossOrigin
    public Integer save_order(@RequestBody Order order)
    { return orderService.save_order(order); }
}
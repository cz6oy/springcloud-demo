package com.baizhi.controller;

import com.baizhi.entity.CreateOrderDTO;
import com.baizhi.entity.OrderResultDTO;
import com.baizhi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("create")
    public OrderResultDTO create(@RequestBody CreateOrderDTO createOrderDTO){
        OrderResultDTO resultDTO = orderService.addOrder(createOrderDTO);
        return resultDTO;
    }
}

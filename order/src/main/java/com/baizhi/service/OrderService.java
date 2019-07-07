package com.baizhi.service;

import com.baizhi.entity.CreateOrderDTO;
import com.baizhi.entity.OrderResultDTO;

public interface OrderService {
    OrderResultDTO addOrder(CreateOrderDTO createOrderDTO);


}

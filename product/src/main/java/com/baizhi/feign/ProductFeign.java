package com.baizhi.feign;


import com.baizhi.entity.CreateOrderDTO;
import com.baizhi.entity.OrderResultDTO;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ORDER")
public interface ProductFeign {

    @RequestMapping(value = "/order/create",method = RequestMethod.POST)
    @LoadBalanced
    public OrderResultDTO add(CreateOrderDTO createOrderDTO);
}

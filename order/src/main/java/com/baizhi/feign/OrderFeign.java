package com.baizhi.feign;


import com.baizhi.entity.ProductInfo;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT")
public interface OrderFeign {

    @RequestMapping("/product/selectById")
    @LoadBalanced
    public ProductInfo select(@RequestParam("id") String id);
}

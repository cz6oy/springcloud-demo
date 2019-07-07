package com.baizhi.service;

import com.baizhi.dao.OrderDetailMapper;
import com.baizhi.dao.OrderMasterMapper;
import com.baizhi.entity.*;
import com.baizhi.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderFeign orderFeign;
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Override
    public OrderResultDTO addOrder(CreateOrderDTO createOrderDTO) {
        //1.添加订单
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress(createOrderDTO.getAddress());
        orderMaster.setBuyerIphone(createOrderDTO.getIphone());
        orderMaster.setBuyerName(createOrderDTO.getName());
        orderMaster.setBuyerOpenid(createOrderDTO.getOpenid());
        orderMaster.setCreateTime(new Date());
        String str = UUID.randomUUID().toString();
        orderMaster.setOrderId(str);
        orderMaster.setOrderStatus(Byte.valueOf("0"));
        orderMaster.setPayStayus(Byte.valueOf("0"));
        orderMaster.setUpdateTime(new Date());
        List<ItemDTO> items = createOrderDTO.getItems();
        Double result = 0.0;
        for (ItemDTO item : items) {
            ProductInfo productInfo = orderFeign.select(item.getProductId());
            result += productInfo.getProductPrice()*item.getProductQuantity();
            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setCreateTime(new Date());
            orderDetail.setDetailId(UUID.randomUUID().toString());
            orderDetail.setOrderId(str);
            orderDetail.setProdcutName(productInfo.getProdcutName());
            orderDetail.setProductIcon(productInfo.getProductIcon());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            orderDetail.setProductQuantity(item.getProductQuantity());
            orderDetail.setUpdateTime(new Date());
            orderDetail.setProductId(productInfo.getProductId());
            orderDetailMapper.insert(orderDetail);
            System.out.println(orderDetail);
        }
        System.out.println("---------------------");
        orderMaster.setOrderAmount(result);
        System.out.println(orderMaster);
        orderMasterMapper.insert(orderMaster);

        OrderResultDTO resultDTO = new OrderResultDTO();
        resultDTO.setCode(0);
        resultDTO.setMsg("成功");
        HashMap<String, String> map = new HashMap<>();
        map.put("orderId",str);
        resultDTO.setData(map);
        return resultDTO;
    }


}

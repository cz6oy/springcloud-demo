package com.baizhi.controller;

import com.baizhi.dao.ProductInfoMapper;
import com.baizhi.entity.*;
import com.baizhi.feign.ProductFeign;
import com.baizhi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductFeign productFeign;
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @RequestMapping("list")
    public String list(HttpServletRequest request) throws InterruptedException {
        ResultDTO all = productService.findAll();
        request.setAttribute("product", all);
        Thread.sleep(3000);
        return "showAll";
    }

    @RequestMapping("addCart")
    public String addCart(String id, String name, Double price, HttpSession session) {
        Map<String, CartDTO> map = (Map<String, CartDTO>) session.getAttribute("cart");
        if (map == null) {
            map = new HashMap<>();
            map.put(id, new CartDTO(id, name, price, 1, price));
        } else {
            CartDTO cartDTO = map.get(id);
            if (map.containsKey(id)) {
                map.put(id, new CartDTO(id, name, price, cartDTO.getCount() + 1, (cartDTO.getCount() + 1) * price));
            } else {
                map.put(id, new CartDTO(id, name, price, 1, price));
            }
        }
        session.setAttribute("cart",map);
        return "showCart";
    }

    @RequestMapping("createOrder")
    @ResponseBody
    public OrderResultDTO createOrder(HttpSession session){
        Map<String,CartDTO> map = (Map<String, CartDTO>) session.getAttribute("cart");
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setAddress("北京职业科技学院");
        createOrderDTO.setIphone("18888888888");
        createOrderDTO.setName("张三");
        createOrderDTO.setOpenid("qwe123");
        Collection<CartDTO> values = map.values();
        ArrayList<ItemDTO> list = new ArrayList<>();
        for (CartDTO value : values) {
            ItemDTO itemDTO = new ItemDTO(value.getId(),value.getCount());
            list.add(itemDTO);
        }
        createOrderDTO.setItems(list);
        OrderResultDTO add = productFeign.add(createOrderDTO);
        return add;
    }

    @RequestMapping("selectById")
    @ResponseBody
    public ProductInfo selectById(String id){
        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(id);
        return productInfo;
    }
}

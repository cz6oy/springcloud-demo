package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDTO implements Serializable {
    private String name;
    private String iphone;
    private String address;
    private String openid;
    private List<ItemDTO> items;

}

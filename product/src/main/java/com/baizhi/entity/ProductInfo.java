package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo implements Serializable {
    private String productId;

    private String prodcutName;

    private Double productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


}
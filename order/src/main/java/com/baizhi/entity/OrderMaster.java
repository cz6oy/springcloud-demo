package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMaster implements Serializable {
    private String orderId;

    private String buyerName;

    private String buyerIphone;

    private String buyerAddress;

    private String buyerOpenid;

    private Double orderAmount;

    private Byte orderStatus;

    private Byte payStayus;

    private Date createTime;

    private Date updateTime;

}
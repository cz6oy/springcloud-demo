package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResultDTO implements Serializable {

    private Integer code;
    private String msg;
    private Map<String,String> data;
}

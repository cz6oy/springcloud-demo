package com.baizhi.dao;

import com.baizhi.entity.CategoryDTO;
import com.baizhi.entity.ProductInfo;

import java.util.List;

public interface ProductInfoMapper {
    ProductInfo selectByPrimaryKey(String productId);
    List<CategoryDTO> selectAll();
}
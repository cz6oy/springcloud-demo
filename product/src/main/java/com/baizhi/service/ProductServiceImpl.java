package com.baizhi.service;

import com.baizhi.dao.ProductInfoMapper;
import com.baizhi.entity.CategoryDTO;
import com.baizhi.entity.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public ResultDTO findAll() {

        ResultDTO resultDTO = new ResultDTO();
        List<CategoryDTO> categoryDTOS = null;
        try {
            categoryDTOS = productInfoMapper.selectAll();
            resultDTO.setCode(0);
            resultDTO.setMsg("成功");
            resultDTO.setData(categoryDTOS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultDTO;
    }
}

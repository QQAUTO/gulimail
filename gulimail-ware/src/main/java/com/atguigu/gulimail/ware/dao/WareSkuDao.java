package com.atguigu.gulimail.ware.dao;

import com.atguigu.gulimail.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author leifengyang
 * @email sunl@gmail.com
 * @date 2021-02-22 16:24:06
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}

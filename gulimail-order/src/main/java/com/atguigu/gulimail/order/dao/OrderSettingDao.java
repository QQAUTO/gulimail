package com.atguigu.gulimail.order.dao;

import com.atguigu.gulimail.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author leifengyang
 * @email sunl@gmail.com
 * @date 2021-02-22 15:52:41
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}

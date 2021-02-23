package com.atguigu.gulimail.member.dao;

import com.atguigu.gulimail.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author leifengyang
 * @email sunl@gmail.com
 * @date 2021-02-22 15:02:18
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}

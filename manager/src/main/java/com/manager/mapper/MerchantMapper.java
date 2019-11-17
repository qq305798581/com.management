package com.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MerchantMapper {
	
	@Select("select MId from merchant where MAccount=#{account}")
	public Integer selectIdByAccount(@Param("account")String account);
	
	@Select("select MAccount from merchant where MId=#{id}")
	public String selectAccountById(@Param("id")int id);
}

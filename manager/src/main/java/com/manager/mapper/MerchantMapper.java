package com.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MerchantMapper {
	
	@Select("select MId from merchant where MAccoun=#{account}")
	public Integer selectIdByAccount(@Param("account")String account);
}

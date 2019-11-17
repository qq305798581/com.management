package com.manager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.manager.domain.Commodity;

@Mapper
public interface CommodityMapper {
	
	@Insert("insert into product(PName,PDescribe,SId,PPrise,MId)"
			+ " value(#{com.name},#{com.description},"
			+ "#{com.secondClass},#{com.prise},#{com.mId})")
	public void addCommodity(@Param("com")Commodity com);
}

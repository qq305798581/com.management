package com.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.manager.domain.Commodity;

@Mapper
public interface CommodityMapper {
	
	@Insert("insert into product(PName,PDescribe,SId,PPrise,MId)"
			+ " value(#{com.PName},#{com.PDescribe},"
			+ "#{com.SId},#{com.PPrise},#{com.MId})")
	public int addCommodity(@Param("com")Commodity com);
	
	
	@Select("select * from product where PId=#{id}")
	public Commodity selectById(@Param("id")int id);
	
	@Delete("delete from product where PId=#{id}")
	public void deleteById(@Param("id")int id);
	
	@Update("update product set PName=#{com.PName},PDescribe=#{com.PDescribe},"
			+ "SId=#{com.SId},PPrise={com.PPrise}")
	public void updateInfo(@Param("com")Commodity com);
}

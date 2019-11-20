package com.manager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.manager.domain.FirstClass;
import com.manager.domain.SecondClass;

public interface CategoryMapper {
	@Insert("insert into fclass(FName) value(#{value.FName})")
	public Integer addFirstCategory(@Param("value")FirstClass fc);
	
	@Insert("insert into sclass(SName,FId) value(#{value.SName},#{value.FId})")
	public Integer addSecondCategory(@Param("value")SecondClass sc);
	
	@Select("select from fclass where FId=#{id}")
	public FirstClass selectFirstById(@Param("id")int id);
	
	@Select("select from sclass where SId=#{id}")
	public SecondClass selectSecondById(@Param("id")int id);
	
	@Update("update fclass set FName=#{fc.FName} where FId=#{fc.FId}")
	public Integer updateFirstClass(@Param("fc")FirstClass fc);
	
	@Update("update sclass set SName=#{sc.SName},FId=#{sc.FId} where SId=#{sc.SId}")
	public Integer updateSecondClass(@Param("sc")SecondClass sc);
}

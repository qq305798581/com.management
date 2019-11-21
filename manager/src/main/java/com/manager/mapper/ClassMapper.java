package com.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.manager.domain.FirstClass;
import com.manager.domain.SecondClass;

public interface ClassMapper {
	
	@Select("select * from fclass")
	public List<FirstClass> getFirstClass();
	
	@Select("select * from sclass")
	public List<SecondClass> getSecondClass();
	
	@Select("select fclass.FName from fclass,sclass where fclass.FId=sclass.FId and sclass.SId=#{id}")
	public String getFirstClassNameBySecondClassId(@Param("id")int id);
	
	@Select("select FId from sclass where SId=#{id}")
	public Integer getFirstIdBySecondId(int id);
	
	@Select("select SName from sclass where SId=#{id}")
	public String getSecondName(@Param("id")int id);
}

package com.manager.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.manager.domain.Merchant;

@Mapper
public interface MerchantMapper {
	
	@Select("select MId from merchant where MAccount=#{account}")
	public Integer selectIdByAccount(@Param("account")String account);
	
	@Select("select MAccount from merchant where MId=#{id}")
	public String selectAccountById(@Param("id")int id);
	
	@Update("update merchant set MAccount=#{mer.MAccount},MPasswd=#{mer.MPasswd},MName=#{mer.MName},MPhone=#{mer.MPhone} where MId=#{mer.MId}")
	public Integer updateMerchant(@Param("mer")Merchant mer);
	
	@Select("select * from merchant where MId=#{id}")
	public Merchant selectMerchantById(@Param("id") int id);
	
	@Insert("insert into merchant(MAccount,MPasswd,MName,MPhone) value(#{mer.MAccount},#{mer.MPasswd},#{mer.MName},#{mer.MPhone})")
	public Integer addMerchant(@Param("mer")Merchant mer);
	
	@Delete("delete from merchant where MId=#{id}")
	public Integer deleteMerchantById(@Param("id")int id);
}

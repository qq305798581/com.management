package com.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.manager.domain.Administrator;
import com.manager.domain.Merchant;


public interface LoginMapper {
	@Select("select * from admin where AAccount=#{account} and APasswd=#{pwd}")
	public Administrator adminLogin(@Param("account")String account, @Param("pwd")String pwd);
	
	@Select("select * from merchant where MAccount=#{account} and MPasswd=#{pwd}")
	public Merchant merchantLogin(String account, String pwd);
}

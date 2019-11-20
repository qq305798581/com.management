package com.manager.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.manager.domain.Commodity;
import com.manager.domain.User;

public interface UserMapper {
	@Insert("insert into user(UName,UPasswd,USex,UTele)"
			+ " value(#{user.UName},#{user.UPasswd},"
			+ "#{user.USex},#{user.UTele})")
	public int addUser(@Param("user")User user);
	
	@Select("select * from user where UTele=#{tele}")
	public User selectUserByTele(@Param("tele")String tele);
	
	@Update("update user set UName=#{user.UName},UPasswd=#{user.Passwd},"
			+ "USex=#{user.USex},UTele={user.UTele} where UId=#{user.UId}")
	public void updateInfo(@Param("user")User user);
	
	@Delete("delete from user where UTele=#{tele}")
	public Integer deleteById(@Param("tele")String tele);
}

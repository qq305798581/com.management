package com.manager.mapper;

import java.io.IOException;
import java.io.InputStream;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class SqlSessionUtil {
	private static SqlSessionFactory sqlSessionFactory = null;
	private static SqlSession session = null;
	static{
		InputStream input;
		try {
			input = Resources.getResourceAsStream("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession(){
		return session;
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}

}

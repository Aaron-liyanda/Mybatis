package com.aaron.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	
	public static SqlSessionFactory getSessionFactor(){
		
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			String resource = "mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}

}

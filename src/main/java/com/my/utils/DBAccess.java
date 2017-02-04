package com.my.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 访问数据库类(Mybatis方式)
 */
public class DBAccess {
	
	/**
	 * 得到SqlSession对象
	 * @throws IOException 
	 */
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库连接信息。注意java文件的路径是是在\messageAutoReply\WEB-INF\classes文件下
		Reader reader= Resources.getResourceAsReader("Configuration.xml");
		// 根据上述信息构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 通过SqlSessionFactory打开一个会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}

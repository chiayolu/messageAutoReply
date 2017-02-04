package com.my.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.my.bean.Message;
import com.my.utils.DBAccess;
import com.my.utils.DBConnector;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 和message相关的数据库操作
 */
public class MessageDao {

	/**
	 * 根据查询条件查询消息列表(JDBC方式)
	 */
	// public List<Message> QueryMessageList(String command, String description)
	// {
	// Connection con = (Connection) DBConnector.getConnection();
	//
	// StringBuilder sql = new StringBuilder("select
	// id,command,description,content from message where 1 = 1");
	// // 用于拼接执行的sql语句，判断有值，才能用preparedStatement.setString
	// List<String> paramList = new ArrayList<String>();
	// if (command != null && !"".equals(command.trim())) {
	// sql.append(" and command = ?");
	// paramList.add(command);
	// }
	// if (description != null && !"".equals(description.trim())) {
	// // 注意：模糊查询中的'%'和?之间是有空格的
	// sql.append(" and description like '%' ? '%'");
	// paramList.add(description);
	// }
	// // 返回从数据库查询出的Message列表
	// List<Message> messageList = new ArrayList<Message>();
	// try {
	// PreparedStatement statement = (PreparedStatement)
	// con.prepareStatement(sql.toString());
	// for (int i = 0; i < paramList.size(); i++) {
	// // 注意：prepatedStatement是从1开始的，不是0
	// statement.setString(i + 1, paramList.get(i));
	// }
	// ResultSet rs = statement.executeQuery();
	//
	// while (rs.next()) {
	// Message message = new Message();
	// messageList.add(message);
	// // 注意：这里面的id是数据库列名，不是Message对象中的属性名
	// message.setId(rs.getString("id"));
	// message.setCommand(rs.getString("command"));
	// message.setDescription(rs.getString("description"));
	// message.setContent(rs.getString("content"));
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return messageList;
	// }

	/**
	 * 根据查询条件查询消息列表(Mybatis方式)
	 */
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		// 结束sqlSession时需要关闭，所以写在try catch外面
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
//			Logger logger = Logger.getLogger("stdout");
//			logger.debug("aaaaaaaaa");
//			System.out.println("bbbbbbbbbb");
			// 通过sqlSession执行sql语句
			messageList = sqlSession.selectList("Message.queryMessageList", message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 删除一条Message数据(Mybatis方式)
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		// 结束sqlSession时需要关闭，所以写在try catch外面
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 删除一条Message数据(Mybatis方式)
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		// 结束sqlSession时需要关闭，所以写在try catch外面
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteBatch", ids);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * main方法测试数据库连接
	 * */
	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
		for (int i = 0; i < 200; i++) {
			System.out.println("INSERT INTO message(id,command,description,content) VALUES ("+ (10+i) +",'test" +i +"','test','test');");
		}
	}
}

package com.my.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接(jdbc方式)
 */
public class DBConnector {
	// public static Connection getConnection() {
	public static Connection getConnection() {
		String user = "root";
		String psw = "123456";
		String url = "jdbc:mysql://localhost:3306/message_auto_reply?user=" + user + "&password=" + psw
				+ "&useUnicode=true&characterEncoding=UTF-8";
		Connection conn = null;
		try {
//			System.out.println("00000000000001");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
//			System.out.println("111111111");
			return conn;
		} catch (Exception e) {
			System.out.println("连接数据库失败");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		DBConnector.getConnection();
	}
}

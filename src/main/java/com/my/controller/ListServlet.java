package com.my.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.bean.Message;
import com.my.utils.DBConnector;
import com.my.dao.MessageDao;
import com.my.service.ListService;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 列表页面初始化控制
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	
	MessageDao messageDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码
//		req.setCharacterEncoding("UTF-8");
		// 接受页面的值
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		// 页面输入的内容显示在页面
		req.setAttribute("command", command);
		req.setAttribute("description", description);

	
		// System.out.println(messageList);
		// 获得根据条件查出的MessageList
		ListService listService = new ListService();
		req.setAttribute("messageList", listService.QueryMessageList(command, description));
		
		// 当有跳转页面代码时(forward(req, resp))，下面输出的输出alert的代码不能用
		// 原因：这个相当于把ListServlet当成一个页面，如果下面还加了跳转，也就直接跳转到其它页面了，所以alert信息不会显示
//		resp.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = resp.getWriter();
//		out.print("<script language='javascript'>alert('删除成功');</script>" );
		
		// servlet之间通信用 req.setAttribute和req.getAttribute
//		String tem = (String) req.getAttribute("aa");
		
//		req.setAttribute("mes", "批量删除成功");
		// 页面跳转
		req.getRequestDispatcher("/site/theme/back/MessageList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}

package com.my.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.MessageDao;
import com.my.service.MaintainService;

/**
 * 删除一条数据
 */
public class DeleteOneServlet extends HttpServlet{
	MessageDao messageDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码(放到了过滤器中)
//		req.setCharacterEncoding("UTF-8");
		// 接受页面的值
		String id = req.getParameter("id");
		
		MaintainService maintainService = new MaintainService();
		maintainService.deleteOne(id);
		

		// 删除成功，返回前台"删除成功信息" 前台ajax获得的function(msg) 中的msg为out.print中的信息
//		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("删除成功(后台传来)");
		
		// DeleteOneServlet向ListServlet传值
//		req.setAttribute("aa", "bb");
		
		// 页面跳转
//		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}

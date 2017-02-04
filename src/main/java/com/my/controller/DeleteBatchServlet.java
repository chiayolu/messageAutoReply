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
 * 批量删除
 */
@SuppressWarnings("serial")
public class DeleteBatchServlet extends HttpServlet{
	MessageDao messageDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码(放到了过滤器中)
//		req.setCharacterEncoding("UTF-8");
		// 接受页面的值
		String[] id = req.getParameterValues("id");
		
		MaintainService maintainService = new MaintainService();
		maintainService.deleteBatch(id);
		
		// 返回删除结果
		req.setAttribute("mes", "批量删除成功");
		// 页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
//		resp.sendRedirect("List.action");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}

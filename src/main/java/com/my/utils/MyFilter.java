package com.my.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 过滤器方法
 */
public class MyFilter implements Filter{

	/* 
	 * 启动web容器的时候调用，只调用一次
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取初始化参数
		String parameter = filterConfig.getInitParameter("parameter"); 

		// 输出初始化参数
		System.out.println("web.xml中设置的参数: " + parameter); 
	}

	/* 
	 * 每一次请求都会调用
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 向后台请求的信息进行UTF-8编码
		request.setCharacterEncoding("UTF-8");
		// 相应的内容设置UTF-8编码
		response.setContentType("text/html;charset=UTF-8");
		// 把请求传回过滤链
		chain.doFilter(request,response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

package com.asule.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	
	请求转发和请求包含：
		两者相同之处在于，都是由一个servlet到另一个servlet，两个servlet共同使用同一个request和resp。
		不同之处在于，请求转发的响应体只能由后一个servlet负责。请求包含可以由两个servlet共同完成。
*/
public class GServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
		request.setAttribute("test", "douban");
		//请求转发和请求包含之间的跳转是服务端之间的跳转，加上'/'，相对的是服务端路径。
		//不加'/'相对于当前servlet路径。
		RequestDispatcher dispatcher=request.getRequestDispatcher("/HServlet");
		
//		请求转发
//		dispatcher.forward(request, resp);
		
//		请求包含
		resp.getWriter().write("douban");
		dispatcher.include(request, resp);
	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

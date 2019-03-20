package com.asule.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	response发送状态码
	response添加响应头
*/
public class DServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
//		设置响应头，一个key对应一个value
		resp.setHeader("key", "value");//setHeader用于单值响应头
		resp.addHeader("key", "x0");//addHeader用于多值响应头
		resp.addHeader("key", "x1");
		resp.addHeader("key", "x2");
//		发送状态码
		resp.sendError(404, "你访问的资源存在,但是就是不给你资源");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

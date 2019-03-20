package com.asule.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	request获取请求头，ip地址，请求方式，请求URL的协议，服务器名，端口
	
	通过refer获取访问来源，它的作用是防盗链(如果不是从指定页面跳转，可以进行处理)
*/
public class FServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*
		 	获取所有请求头
		 */
		Enumeration names=request.getHeaderNames();
		while(names.hasMoreElements()){
			System.out.println(names.nextElement());
		}
		
//		获取IP地址和请求方式
		request.getRemoteAddr();
		request.getMethod();
		
//		Mozilla/5.0 (Windows NT 10.0; Win64; x64) 
//		AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.78 Safari/537.36
		String agent=request.getHeader("User-Agent");
		System.out.println(agent);
		
//		获取请求url的协议，服务器名，端口
		String s0=request.getScheme();	//请求URL的协议
		String s1=request.getServerName();//请求URL的域名
		int s2=request.getServerPort();//端口
				
		String s3=request.getContextPath();//获取项目名
		
		String s4=request.getServletPath();//获取Servlet路径
		
		String s5=request.getQueryString();//获取参数部分
		
		String s6=request.getRequestURI();//请求URI，等于项目名+servlet路径
		
		StringBuffer s7=request.getRequestURL();//请求URL，去掉参数的路径
		
		System.out.println(s0+"\n"+
				s1+"\n"+
				s2+"\n"+
				s3+"\n"+
				s4+"\n"+
				s5+"\n"+
				s6+"\n"+
				s7.toString()+"\n"
				);
	
	
//		获取访问来源
		String refer=request.getHeader("Referer");
		System.out.println(refer);
	
		/**
			  请求参数，有可能是在请求体中，也有可能是在url中。
			 无论是post还是get，获取这些参数的方法都是相同的。
			 但是，这两种方式处理编码的方式略有不同。
		 */
//		一个请求参数对应一个值
		request.getParameter("");
//		可能一个请求参数对应多个值
		request.getParameterValues("");
//		获取所有请求参数的名称
		request.getParameterNames();
//		key是请求名，值是请求名称
		request.getParameterMap();
		
		
	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

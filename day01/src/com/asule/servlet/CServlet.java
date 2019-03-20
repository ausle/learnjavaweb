package com.asule.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//学习ServletContext
/*
	ServletContext：
		服务器会为每个应用创建一个ServletContext，
		它的生命周期是，服务器开启时创建，服务器关闭时销毁。
		所以可以利用它，在多个servlet之间共享数据。
	
	获取ServletContext：
		GenericServlet的init方法中，把传递进来的ServletConfig抽取为了成员变量。
		在GenericServlet中，通过getServletConfig获取到该成员变量。
		而ServletConfig可以通过getServletContext获取到ServletContext。
		而HttpServlet继承自GenericServlet。
		
		除了这两种，还有，
		HttpSession和ServletEvent的getServletContext方法。
	
	ServletContext域对象:
		ServletContext是JavaWeb四大域对象之一，另外三个是：
		PageContext,ServletRequest,HttpSession。
		域对象都有存储数据的功能，因为内部有个map。可以有set,get,removeAttribute等方法。
	
	ServletContext获取公共的初始化参数<context-param>：
		<init-param>是每一个servlet的参数信息。而<context-param>是公共的初始化参数。
		不要把这两个弄混。
		可以通过getInitParameter,来获取<context-param>初始化参数值。
	
	
	ServletContext获取真实路径：
		ServletContext context=getServletContext();	
		context.getRealPath("")
			获取真实路径,就是带有盘符的路径。
		context.getResourceAsStream("")
			根据文件路径，获取该文件的流。
		context.getResourcePaths("")
			获取指定目录下的所有资源的路径。
			
	
	class和classloader获取资源路径：
		
				

*/
public class CServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	
		ServletContext context=getServletContext();
		String realPath=context.getRealPath("/WEB-INF");
		context.getResourceAsStream("");
		Set<String> subPaths=context.getResourcePaths("/WEB-INF");
		
//		class和classloader获取资源路径
		
		Class clazz=getClass();
		//相对于是class文件所在的目录。
		InputStream i=clazz.getResourceAsStream("a.txt");
		//如果加上 '/'那么表示与class目录在同一层级
		clazz.getResourceAsStream("/a.txt");
		
		ClassLoader classLoader=clazz.getClassLoader();
		//类加载器目录，相对于class目录
		classLoader.getResourceAsStream("a.txt");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	
}

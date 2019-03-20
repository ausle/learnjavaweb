package com.asule.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
什么是servlet?
	JavaWeb三大组件之一，服务器会把接收到的请求交给servlet去处理。
	servlet处理的过程是：接收请求数据，处理请求，做出响应。
	
1，Servlet的生命周期：
	init
	service
	destory
	
2，Servlet由我们实现后，该Servlet对象是由服务器创建，相关方法也是由服务器来调用。


3，ServletConfig对应的就是web.xml中每个servlet的配置信息对象。
	<servlet>
	    <servlet-name>AServlet</servlet-name>
	    <servlet-class>com.asule.study.AServlet</servlet-class>
	    <init-param>
	    	<param-name>test</param-name>
	    	<param-value>testvalue</param-value>
	    </init-param>
  	</servlet>

*/
public class AServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
		
	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");
		ServletConfig config=getServletConfig();
		ServletContext context=config.getServletContext();
			
		String parameter = config.getInitParameter("test");
		System.out.println("parameter");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("service");
	}
	
}

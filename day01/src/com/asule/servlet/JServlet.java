package com.asule.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	响应编码&&请求编码&&URL编码
*/
public class JServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
	
	//响应编码
	/*	
	  	服务器默认编码解码参照的是iso-8859-1编码表。
	  	我们可以设置对响应内容的编码为utf-8，如：
	  		resp.setCharacterEncoding("utf-8");
	  	但是，浏览器如果使用其他码表来解码，依然会出现乱码。
	  	这时可以添加一个Content-Type响应头，告知浏览器服务器要使用什么码表来响应数据。
	  	如：
	  		resp.setHeader("Content-Type", "text/html;charset=utf-8");	
	  	这种写法也可以写简洁的写为：	
	  		resp.setContentType("text/html;charset=utf-8");
	*/
		
	
	
	//请求编码
	/*	
		请求数据，可以是在地址栏输入的
		
		对于post请求，在获取内容之前，先设置该内容实体的编码:
		request.setCharacterEncoding("utf-8");
		然后通过request.getParameter("")获取参数。
		
		对于get请求，
		在tomcat中，request.getParameter("")获取参数默认使用的是iso-8859-1编码表，
		获取到iso-8859-1解码后的字符串，再对其进行iso-8859-1编码，然后按照utf-8进行解码。
			String value=request.getParameter("name");
	 		byte[] bufs=value.getBytes("iso-8859-1");
	 		String newvalue=new String(bufs,"utf-8");
	*/
		
	 
	 
	
	//URL编码
	/*	
  		post提交表单时，请求头为Content-type：Content-Type: application/x-www-form-urlencoded
  		它表示一种URL编码，是为了在客户端和服务端之间传递中文时把它转换成网络合适的方式。	
  		(中文在网络传输时不是很稳定。)
  		
  		指定请求体为什么编码，并不影响URL编码。URL编码是在为请求体编码之上的一种编码。目的就是为了方便网络传输。
 		服务器能自动识别URL编码。可以被转换回来。
 		
 		对于GET请求中的中文，由于中文的特性，可能会丢失字节。那么可以使用下面的方法，手动为其添加URL编解码：
 			URLEncoder.encode("test","utf-8");
			URLDecoder.decode("test","utf-8");
  		而对于POST请求，表单自带URL编码，并且服务器会自动识别URL而进行解码，所以不用我们添加。
	*/	
	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

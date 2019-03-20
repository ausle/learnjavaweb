package com.asule.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	重定向&&定时重定向&&禁用浏览器缓存&&响应字节数据
*/
public class EServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*
			重定向，发送location头附带新的请求地址，发送302状态码
		*/
//		resp.setHeader("Location", "/day01/BServlet");
//		resp.setStatus(302);
//		另一种快捷方法来完成重定向，其实内部还是使用的上面的方式来完成请求重定向
//		response.sendRedirect("/day01/BServlet");
		
		/*
			定时重定向
			refresh请求头，可以设置一个时间重定向到某个页面，和重定向十分相似
		*/
		resp.setHeader("Refresh","5;URL=day01/BServlet");
		
		
		/*
		  	禁用浏览器缓存
		  	缓存功能在开发阶段，不要使用。上线阶段，需要使用缓存功能。
		 */
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("progma", "no-cache");
//		缓存时间为-1，也就是不缓存
		resp.setDateHeader("expires",-1);
		
		
		/*
			响应字节数据(图片)
		*/
		String path="E:\\chen.jpg";
		FileInputStream file=new FileInputStream(path);
		ServletOutputStream output=resp.getOutputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=file.read(buf))!=-1){
			output.write(buf, 0, len);
		}
		
	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

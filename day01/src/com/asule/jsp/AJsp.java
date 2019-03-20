package com.asule.jsp;

public class AJsp {

}
//jsp入门需知
/*
	
1,jsp作用
	servlet不适合输出html响应体，因为需要不停的write。
	而又无法单纯的只使用html，无法设置动态资源。
	我们可以在html中，添加java脚本，构成jsp页面。

2，jsp和servlet的分工
	访问一个jsp，显示页面，servlet负责处理数据，把数据填充到jsp页面，然后再输出jsp页面。
	
3，jsp组成:html+java脚本+jsp标签

4，jsp使用的9大内置对象
   jsp无需创建就可以使用的对象共有9个，称为9大内置对象。
	
5,3种java脚本和jsp注释
	<%...%>java代码片段
	<%=...=%>java表达式，常用于输出一条结果
	<%!...%>声明，常用于创建类的成员变量和方法
	<%--...--%>,注释
	
6，jsp工作原理
	在服务器启动第一次访问某个jsp页面时，就会翻译为java文件，其实就是一个servlet。
	编译java为class文件，并创建该对象，调用其service方法。
	第二次访问该jsp，直接调用其service。
	
	在该service中，会首先初始化下面几个对象：
		final javax.servlet.jsp.PageContext pageContext;
	    javax.servlet.http.HttpSession session = null;
	    final javax.servlet.ServletContext application;
	    final javax.servlet.ServletConfig config;
	    javax.servlet.jsp.JspWriter out = null;
	    final java.lang.Object page = this;
	    javax.servlet.jsp.JspWriter _jspx_out = null;
	    javax.servlet.jsp.PageContext _jspx_page_context = null;



*/
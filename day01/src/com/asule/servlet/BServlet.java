package com.asule.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
	
1，在继承HttpServlet时要注意的地方：	
	不重写doGet和doPost，会出现405。
	同样也不要去调用super.doxxx方法。
	

2，有几个servlet细节：
	①线程安全的问题:
		多个线程访问servlet时，可能会出现线程安全问题。
		在servlet中创建局部变量，而不要创建成员变量。
		
		如果要在servlet中创建成员变量，创建无状态的成员变量是可以的。
		(无状态的成员指的是，该成员变量不对数据进行设置，比如只是有输出语句的功能。)
		如果要创建有状态的成员变量，一定不要有可以set的方法。
		
	
	②让服务器可以启动就创建servlet
		只需在<servlet></servlet>中添加<load-on-startup></load-on-startup>标签。
	
	③url-pattern的一些细节
		可以让多个url-pattern指定一个servlet-name。如这样：
			 <servlet-mapping>
			    <servlet-name>SecondServlet</servlet-name>
			    //指定多个路径	
			    <url-pattern>/servlet/SecondServlet</url-pattern>
			    <url-pattern>/SecondServlet</url-pattern>
 	 		</servlet-mapping>
		目的就是，为一个servlet定义多个访问路径。
		
		url-pattern中可以写通配符，但一个规则，通配符不可以出现在中间位置，也不可以直接有通配符。
		如下：
			/*
			*.do	
		错误的写法：
			/*.do	error	
	
	
	④tomcat下的web.xml的了解
		每个javaWeb应用都需要有web.xml，
		而{CATALINA_HOME}/bin/conf/下的web.xml是所有web.xml的一个共同父文件。
		(tomcat安装目录：)
		这个web.xml的内容有：
			<servlet>
		        <servlet-name>default</servlet-name>
		        <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
		        ....
		        <load-on-startup>1</load-on-startup>
	    	</servlet>
			对应的mapping是：
			<servlet-mapping>
		        <servlet-name>default</servlet-name>
		        <url-pattern>/</url-pattern>
	    	</servlet-mapping>
	    	"/"是优先级最低的通配符，当servlet访问不到时，就会访问DefaultServlet，
	    	而这个DefaultServlet展示的就是404的页面。
	    	
	    	<servlet>
		        <servlet-name>jsp</servlet-name>
		        <servlet-class>org.apache.jasper.servlet.JspServlet</servlet-class>
		        ....
		        <load-on-startup>3</load-on-startup>
	    	</servlet>
	    	 
		     <servlet-mapping>
		        <servlet-name>jsp</servlet-name>
		        <url-pattern>*.jsp</url-pattern>
		        <url-pattern>*.jspx</url-pattern>
			</servlet-mapping>
	    	通过上面可以看出，所有的jsp,jspx都会匹配到一个叫JspServlet的servlet。
	    	这个JspServlet做的就是，把动态资源转化为静态资源。
	    	不难看出，jsp的代码和最终生成的html代码是不同的，这里面有一个资源转化的过程，
	    	这个过程就是JspServlet来完成的。
		
3，输入地址，是怎么创建servlet对象的?		
		当输入访问路径，利用dem4j来解析xml，访问路径和xml内容进行匹配。
		匹配到servlet-class，接着利用反射创建对应的Class，接着可以创建对应的Servlet对象。
		服务器在创建Servlet对象时，会去调用有参的构造器，在该构造器下调用无参的构造器。
		我们可以覆盖这两种构造器，但是要注意的是在覆盖有参构造器时，需要到父类进行构造函数初始化。
*/
public class BServlet extends HttpServlet {
	
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("Bservlet");
	}

}

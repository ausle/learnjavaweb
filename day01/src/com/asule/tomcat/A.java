package com.asule.tomcat;

public class A {
	
}
//tomcat配置(虚拟主机和外部应用)

/*
web资源：静态资源和动态资源

访问web资源：
	输出网址访问web资源
	
web服务器:	
	访问网址，每个域名对应着一个ip地址，对应着一台服务器。
	服务器上有web容器，负责接收请求，做出响应。
	现在学习的是，web容器是tomcat。

Tomcat
	Tomcat安装
	Tomcat启动，关闭，配置
	Tomcat目录结构
	
web应用：	
	WEB-INF目录下不可以被客户端直接访问。

myeclipse创建javaweb项目

tomcat配置：
配置外部应用：
	tomcat默认会把项目部署到webapps下，
	配置外部应用的意思是，把项目放在tomcat的webapps之外，还可以访问该应用。
	
	第一种方式：
		CATALINA_HOME\conf\server.xml的Host标签下添加Context标签:
					<Context path="day01A" docBase="D:\copy\day01"/>
		path指定访问路径，映射的实际路径为docBase指定的位置。
		访问"http://localhost/day01A"即可。
		
	第二种方式：
		CATALINA_HOME\conf\Catalina\localhost下添加一个以path为名的xml文件。
		在该文件下定义docBase。
		如果我想以"http://localhost/day01A"该路径访问资源，那么该xml文件名为day01A，
		该xml内容为：<Context docBase="D:\copy\day01"/>

		
配置虚拟主机：
	在C:\Windows\System32\drivers\etc\hosts文件下，添加一个主机名和ip地址的映射关系:
	127.0.0.1		www.asule.com
	
	在CATALINA_HOME\conf\server.xml添加一个Host
	<Host name="www.asule.com"  appBase="D:\copy\webapps"
            unpackWARs="true" autoDeploy="true">
	</Host>	
	其中appBase指向了一个新的位置，因为要达到访问域名(而不添加项目名)直接访问web资源，必须要有ROOT目录，
	为了使Tomcat的webapps的ROOT目录不受污染，我自己定义了一个webapps，并把我的项目放到了该webapps的
	ROOT下。
	
	这样当直接访问http://www.asule.com/，就可以直接访问ROOT下的资源了 。
	 

 用fiddler抓包记录一个POST请求过程。
	
	Content-Type: application/x-www-form-urlencoded
	着重要说的是，这个Content-Type，它表示url编码。
	 
	 
*/
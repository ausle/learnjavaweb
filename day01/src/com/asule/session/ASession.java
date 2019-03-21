package com.asule.session;

public class ASession {

}
/*
session会话：	
	session会话指的是，对服务器多次连贯性的请求，中间没有关闭客户端。而会话结束的标志，就是关闭该浏览器。

创建session对象：
	服务器会为每个用户创建一个session对象，它保存在服务器的一个map中，该map称为session缓存。	
	
session的一些特点：	
	session是servlet三大域对象，该对象内置在jsp中，可以直接使用。
	session底层依赖的技术是，cookie技术。	

session原理：
	只有当第一次获取session时，服务器才会创建session。
	创建好session后，会把sessionId保存到cookie中。
	(添加一个set-cookie响应头，格式为Set-Cookie: JSESSIONID=...)
	
	那么下次访问时，就会带着该sessionId，并且通过该sessionId获取session。
	
	session默认的不活跃时间为30分钟，如果超过该时间，tomcat会把该session从session池中移除。
	session.getMaxInactiveInterval();可以获取session的最大不活跃时间。
	
	当一个会话结束时，再次打开一个会话，此时的sessionId是丢失的，getsession会创建一个新的session，
	并添加sessionId到cookie中。
	
	session.isNew();判断session是获取的，还是新创建的。主要看的是cookie中是否有sessionId。
		
	session.invalidate();使session失效。
	
	session.getSession(false)，只返回session缓存中存在的session，不会新建session，如果session
	缓存中不存在，那么返回null。
	
session的url重写：
	如果禁用cookie，那么就无法添加sessionId。也就无法使用session技术。
	这时候，可以把sessionId添加到每次访问的url上。
	
	response.encodeURL("/day01/AServlet");
	该方法的作用是，会判断cookie中是否有sessionId，(也可以认为会判断是否支持cookie)，
	如果没有sessionId，会在URL后添加sessionId。
	而如果支持cookie，且带有sessionId，则URL后不会添加sessionId。
*/
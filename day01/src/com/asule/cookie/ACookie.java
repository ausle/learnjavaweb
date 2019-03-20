package com.asule.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ACookie extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}
	
}
/*
	
服务端发送一个set-cookie的响应头，下次客户端访问时，就会带着该cookie信息。

可以利用cookie技术：
	来跟踪客户端的状态。
	记录购物车的信息(无法用request记录购物车信息，因为往往需要向服务器发送多个请求)。
	记录登录状态。
	
cookie的生命：
	Cookie cookie=new Cookie(name, value);
	cookie.setMaxAge(maxAge);
	如果maxAge为0，那么就会立即删除该cookie。
	如果小于0，cookie只会在浏览器的内存中存在。当浏览器关闭后，该cookie也就不存在了。
	如果是某个具体的值，那么它的生命就为多少。单位是毫秒。
	
cookie的路径：
	可以为cookie设置路径，当你访问的路径包含某个cookie的路径时，就会带上该cookie的信息。
	而不是携带所有cookie的信息。

cookie的domain:
	设置cookie的域名，当多个二级域名中共享cookie。
	如：
		cookie.setDomain("*.baidu.com");
		那么，在www.baidu.com,zhidao.baidu.com之间共享cookie。
	
	
	
	
	
	
*/
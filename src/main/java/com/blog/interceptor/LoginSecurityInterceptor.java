/**  
 * Project Name:blog  
 * File Name:SecurityInterceptor.java  
 * Package Name:com.blog.interceptor  
 * Date:2016-8-12上午11:33:13  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.interceptor;  


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**  
 * ClassName:SecurityInterceptor <br/>  
 * Function: 后台登陆拦截. <br/>  
 * Date:     2016-8-12 上午11:33:13 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class LoginSecurityInterceptor implements HandlerInterceptor{
    Logger logger = Logger.getLogger(LoginSecurityInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//String url = request.getRequestURL().toString();
        //String method = request.getMethod();
        String uri = request.getRequestURI();
        if(uri.equals("/blog/loginSuccess")){
        	// 验证用户是否登陆
    		Object obj = request.getSession().getAttribute("userName");
    		if (obj == null) {
    			response.sendRedirect(request.getContextPath() + "/login.html");
    			return false;
    		}
        }
        
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		  
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		  
		
	}
	
}
  

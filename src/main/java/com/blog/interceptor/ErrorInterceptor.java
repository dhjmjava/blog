/**  
 * Project Name:blog  
 * File Name:ErrorInterceptor.java  
 * Package Name:com.blog.interceptor  
 * Date:2016年10月22日下午9:23:38  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.interceptor;  

/**  
 * ClassName:ErrorInterceptor <br/>  
 * Function: 错误拦截器. <br/>  
 * Date:     2016年10月22日 下午9:23:38 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class ErrorInterceptor /*implements HandlerInterceptor*/{
	
	/*Logger logger = Logger.getLogger(Error.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		  
		// TODO Auto-generated method stub  
		return false;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		  
	    logger.info(">>>MyInterceptor2>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");  
	    if(response.getStatus()==500){  
	        modelAndView.setViewName("/error/500");  
	    }else if(response.getStatus()==404){  
	        modelAndView.setViewName("/error/404");  
	    }   
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		  
		// TODO Auto-generated method stub  
		
	}*/

}
  

/**  
 * Project Name:blog  
 * File Name:ErrorController.java  
 * Package Name:com.blog.controller  
 * Date:2016年10月22日下午9:45:13  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.controller;  

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**  
 * ClassName:ErrorController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2016年10月22日 下午9:45:13 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
//@Controller
public class ErrorController {
	
	public static final String DEFAULT_ERROR_VIEW = "error";

	/*@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		e.printStackTrace();
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW+"/500");
		return mav;
	}
	
	@ResponseBody
	@ExceptionHandler(value = BusinessException.class)
	public String businessErrorHandler(HttpServletRequest req, BusinessException e)throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return "出错了0.0";
	}*/
	
	@RequestMapping("error/404")
	public ModelAndView error404(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(DEFAULT_ERROR_VIEW+"/400");
		return mav;
	}
	
	@RequestMapping("error/500")
	public ModelAndView error500(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(DEFAULT_ERROR_VIEW+"/500");
		return mav;
	}

}
  

/**  
 * Project Name:blog  
 * File Name:BaseController.java  
 * Package Name:com.blog.controller  
 * Date:2016-8-11下午3:57:54  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.controller;  

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.service.BlogCommentsService;
import com.blog.service.BlogService;
import com.blog.service.BlogTypesService;
import com.blog.service.BloggerService;
import com.blog.service.LinkService;

/**  
 * ClassName:BaseController <br/>  
 * Function: controller基类. <br/>  
 * Date:     2016-8-11 下午3:57:54 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class BaseController {
	
	@Autowired
	protected HttpSession session;
	
	@Autowired
	protected BloggerService bloggerServiceImpl;
	
	@Autowired
	protected BlogTypesService blogTypesServiceImpl;
	
	@Autowired
	protected BlogService blogServiceImpl;
	
	@Autowired
	protected LinkService linkServiceImpl;
	
	@Autowired
	protected BlogCommentsService blogCommentsServiceImpl;
	
}
  

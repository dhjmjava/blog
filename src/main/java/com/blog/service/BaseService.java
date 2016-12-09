/**  
 * Project Name:blog  
 * File Name:BaseService.java  
 * Package Name:com.blog.service  
 * Date:2016-8-11下午3:58:11  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.service;  

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.mapper.BlogCommentsMapper;
import com.blog.mapper.BlogMapper;
import com.blog.mapper.BlogTypesMapper;
import com.blog.mapper.BloggerMapper;
import com.blog.mapper.LinkMapper;

/**  
 * ClassName:BaseService <br/>  
 * Function: 基础业务接口. <br/>  
 * Date:     2016-8-11 下午3:58:11 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class BaseService {
	
	@Autowired
	protected BloggerMapper bloggerMapper;
	
	@Autowired
	protected BlogMapper blogMapper;
	
	@Autowired
	protected  BlogTypesMapper blogTypesMapper;
	
	@Autowired
	protected LinkMapper linkMapper;
	
	@Autowired
	protected BlogCommentsMapper blogCommentsMapper;

}
  

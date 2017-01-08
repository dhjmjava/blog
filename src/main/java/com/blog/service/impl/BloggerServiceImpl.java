/**  
 * Project Name:blog  
 * File Name:BloggerServiceImpl.java  
 * Package Name:com.blog.service.serviceImpl  
 * Date:2016-8-12上午9:42:50  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.service.impl;  

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.entity.Blogger;
import com.blog.service.BaseService;
import com.blog.service.BloggerService;

/**  
 * ClassName:BloggerServiceImpl <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2016-8-12 上午9:42:50 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Service
public class BloggerServiceImpl extends BaseService implements BloggerService {

	@Override
	public Blogger getBloggerInfoById(long id) {
	    
		return bloggerMapper.queryBloggerInfoById(id);
		
	}

	@Override
	public List<Blogger> getAllBlogger() {
		  
		return bloggerMapper.getAllBlogger();
		
	}

	@Override
	public int updateBloggerInfo(Blogger blogger) {
		  
		return bloggerMapper.updateBloggerInfo(blogger);
		
	}

}
  

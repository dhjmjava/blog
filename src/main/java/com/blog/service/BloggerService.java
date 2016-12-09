/**  
 * Project Name:blog  
 * File Name:BloggerService.java  
 * Package Name:com.blog.service  
 * Date:2016-8-12上午9:42:30  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.service;  

import java.util.List;

import com.blog.entity.Blogger;

/**  
 * ClassName:BloggerService <br/>  
 * Function: 博主信息接口. <br/>  
 * Date:     2016-8-12 上午9:42:30 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface BloggerService {
	
	public Blogger getBloggerInfoById(long id);
	
	public List<Blogger> getAllBlogger();
	
	public int updateBloggerInfo(Blogger blogger);

}
  

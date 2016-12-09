/**  
 * Project Name:blog  
 * File Name:BlogTypesService.java  
 * Package Name:com.blog.service  
 * Date:2016年9月25日下午6:06:42  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.service;  

import java.util.List;

import com.blog.entity.BlogTypes;

/**  
 * ClassName:BlogTypesService <br/>  
 * Function: 博客类别接口. <br/>  
 * Date:     2016年9月25日 下午6:06:42 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface BlogTypesService {

	public List<BlogTypes> getAllBlogTypes();
	
	public BlogTypes getBlogTypesById(long id);
	
	public int updateType(BlogTypes type);
	
	public int addType(BlogTypes type);
}
  

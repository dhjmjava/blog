/**  
 * Project Name:blog  
 * File Name:BlogService.java  
 * Package Name:com.blog.service.serviceImpl  
 * Date:2016-8-11下午3:31:57  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.service;  


import java.util.List;

import com.blog.entity.Blog;
import com.blog.util.Page;

/**  
 * ClassName:BlogService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2016-8-11 下午3:31:57 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface BlogService {
  
	public Page<Blog> getBlogList(int offset,int limit);
	
	public Page<Blog> getBlogPage(int currPage,int pageSize,long typeId,String searchDate);
	
	public List<Blog> getBlogDate();
	
	public List<Blog> getBlogType();
	
	public int deleteBlog(long id);
	
	public boolean saveBlog(Blog blog);
	
	public Blog getBlogById(long id);
	
	public int updateBlog(Blog blog);
	
	public List<Blog> getBlogByComm();
	
	public List<Blog> getAll();
	
}
  

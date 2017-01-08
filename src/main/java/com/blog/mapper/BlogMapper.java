/**  
 * Project Name:blog  
 * File Name:BlogMapper.java  
 * Package Name:com.blog.mapper  
 * Date:2016-8-11下午3:07:44  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.mapper;  

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.blog.entity.Blog;

/**  
 * ClassName:BlogMapper <br/>  
 * Function: 博客管理接口. <br/>  
 * Date:     2016-8-11 下午3:07:44 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface BlogMapper{
	public List<Blog> getAll();
	
	public List<Blog> getAllBlog(@Param("params") Map<String, Integer> map);
	
	//分页查询
	public List<Blog> getBlogPage(@Param("params") Map<String, Object> map);
	
	//月份分类
	public List<Blog> getBlogByDate();
	
	//类型分类
	public List<Blog> getBlogByType();
	
	public int saveBlog(Blog Blog);
	
	public int deleteBlog(long id);
	
	public int updateBlog(Blog blog);
	
	public Blog getBlogById(long id);
	
    //查询总条数
	public int getblogCount(@Param("params") Map<String, Object> map);
	
	//获取有评论的blog
	public List<Blog> getBlogByComments();
	
}
  

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

import com.blog.entity.Blogger;

/**  
 * ClassName:BlogMapper <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2016-8-11 下午3:07:44 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface BloggerMapper {
	
   public int saveBloggerInfo(Blogger blogger);
   
   public int updateBloggerInfo(Blogger blogger);
   
   public int deleteBlogger(long id);
   
   public Blogger queryBloggerInfoById(long id);
   
   public List<Blogger> getAllBlogger();
}
  

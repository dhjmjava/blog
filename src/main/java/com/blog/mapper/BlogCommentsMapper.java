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

import com.blog.entity.BlogComments;

/**  
 * ClassName:BlogMapper <br/>  
 * Function: 评论管理接口. <br/>  
 * Date:     2016-8-11 下午3:07:44 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface BlogCommentsMapper {
	
   public List<BlogComments> queryComments(long blog_id);
   
   public int saveComment(BlogComments comment);
   
   public int deleteComment(long id);
   
   
}
  

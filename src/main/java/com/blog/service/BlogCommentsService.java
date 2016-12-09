/**  
 * Project Name:blog  
 * File Name:BlogCommentsService.java  
 * Package Name:com.blog.service  
 * Date:2016年11月9日上午12:50:25  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.service;  

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.blog.entity.BlogComments;
import com.blog.util.ErrorInfo;

/**  
 * ClassName:BlogCommentsService <br/>  
 * Function: 评论管理接口. <br/>  
 * Date:     2016年11月9日 上午12:50:25 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface BlogCommentsService {
    
	public ErrorInfo saveComment(String content,long blogId,HttpServletRequest request);
	
	public List<BlogComments> queryCommentsByBid(long blog_id); 
	
	public boolean deleteComm(long id);
}
  

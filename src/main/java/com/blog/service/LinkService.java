/**  
 * Project Name:blog  
 * File Name:LinkService.java  
 * Package Name:com.blog.service  
 * Date:2016年10月3日下午11:07:16  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.service;  

import java.util.List;

import com.blog.entity.Link;

/**  
 * ClassName:LinkService <br/>  
 * Function: link管理. <br/>  
 * Date:     2016年10月3日 下午11:07:16 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface LinkService {
  
	public List<Link> getLinkList();
	
	public int deleteLink(long id);
	
	public int addLink(Link link);
	
	public int updateLink(Link link);
	
	public Link getLinkById(long id);
}
  

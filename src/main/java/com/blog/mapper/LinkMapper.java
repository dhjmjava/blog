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

import com.blog.entity.Link;

/**  
 * ClassName:BlogMapper <br/>  
 * Function: 友情链接. <br/>  
 * Date:     2016-8-11 下午3:07:44 <br/>  
 * @author   Administrator  
 * @version  
 * @since    JDK 1.6  
 * @see        
 */
public interface LinkMapper {

	public List<Link> queryAllLink();
	
	public int deleteLink(long id);
	
	public int saveLink(Link link);
	
	public int updateLink(Link link);
	
	public Link getLinkById(long id);
}
  

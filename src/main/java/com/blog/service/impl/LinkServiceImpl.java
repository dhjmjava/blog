/**  
 * Project Name:blog  
 * File Name:LinkServiceImpl.java  
 * Package Name:com.blog.service.impl  
 * Date:2016年10月3日下午11:08:29  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.service.impl;  

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.entity.Link;
import com.blog.service.BaseService;
import com.blog.service.LinkService;

/**  
 * ClassName:LinkServiceImpl <br/>  
 * Function: link实现. <br/>  
 * Date:     2016年10月3日 下午11:08:29 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Service
public class LinkServiceImpl extends BaseService implements LinkService {

	@Override
	public List<Link> getLinkList() {
		return linkMapper.queryAllLink();
	}

	@Override
	public int deleteLink(long id) {
		  
		return linkMapper.deleteLink(id);
		
	}

	@Override
	public int addLink(Link link) {
		  
		return linkMapper.saveLink(link);
		
	}

	@Override
	public int updateLink(Link link) {
		  
		return linkMapper.updateLink(link);
		
	}

	@Override
	public Link getLinkById(long id) {
		  
		return linkMapper.getLinkById(id);
		
	}
	
	

}
  

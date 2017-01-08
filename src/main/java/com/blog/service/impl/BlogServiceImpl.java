/**  
 * Project Name:blog  
 * File Name:BlogServiceImpl.java  
 * Package Name:com.blog.service.serviceImpl  
 * Date:2016-8-11下午3:33:07  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.service.impl;  

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.blog.constants.Constants;
import com.blog.entity.Blog;
import com.blog.service.BaseService;
import com.blog.service.BlogService;
import com.blog.util.DateUtil;
import com.blog.util.Page;

/**  
 * ClassName:BlogServiceImpl <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016-8-11 下午3:33:07 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Service
public class BlogServiceImpl extends BaseService implements BlogService{

	Logger logger = Logger.getLogger(BloggerServiceImpl.class);
	/**
	 * 后台blog分页（可选）.  
	 * @see com.blog.service.BlogService#getBlogList(int, int)
	 */
	@Override
	public Page<Blog> getBlogList(int offset,int limit) {
		Map<String,Integer> map  = new HashMap<String, Integer>();
		map.put("offset", (offset-1)*limit);
		map.put("limit", limit);
		
		List<Blog> blogs = blogMapper.getAllBlog(map);
		int totalCount =  blogMapper.getblogCount(null);
		
		Page<Blog> page = new Page<Blog>();
		page.page = blogs;
		page.currPage = offset;
		page.pageSize = limit;
		page.totalCount = totalCount;
		page.setPageNumber(page.totalCount);
		  
		return page;
	}

	@Override
	public int deleteBlog(long id) {
		  
		return blogMapper.deleteBlog(id);
		
	}

	@Override
	public boolean saveBlog(Blog blog) {
		boolean flag = false;
		try {
			flag = blogMapper.saveBlog(blog) <= 0?false:true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	@Override
	public int updateBlog(Blog blog) {
		
		return blogMapper.updateBlog(blog);
		
	}

	@Override
	public Blog getBlogById(long id) {
		  
		return blogMapper.getBlogById(id);
		
	}


	@Override
	public Page<Blog> getBlogPage(int currPage,int pageSize,long typeId,String searchDate) {
		String[] strings = DateUtil.getDate(searchDate);
		
    	Map<String,Object> conditions = new HashMap<String,Object>();
    	conditions.put("currPage", (currPage-1)*pageSize);
    	conditions.put("pageSize", Constants.TEN);
    	conditions.put("blog_type", typeId);
    	conditions.put("startTime", strings[0]);
    	conditions.put("endTime", strings[1]);

		List<Blog> blogs = blogMapper.getBlogPage(conditions);
		int totalCount =  blogMapper.getblogCount(conditions);
		
		Page<Blog> page = new Page<Blog>();
		page.page = blogs;
		page.pageSize = pageSize;
		page.currPage = currPage;
		page.totalCount = totalCount;
		page.setPageNumber(page.totalCount);
		
		return page;

	}

	@Override
	public List<Blog> getBlogDate() {
		  
		return blogMapper.getBlogByDate();
		
	}

	@Override
	public List<Blog> getBlogType() {
		  
		return blogMapper.getBlogByType();
		
	}

	@Override
	public List<Blog> getBlogByComm() {
		  
		return blogMapper.getBlogByComments();
		
	}

	@Override
	public List<Blog> getAll() {
		  
		return blogMapper.getAll();
		
	}

}
  

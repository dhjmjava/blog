/**  
 * Project Name:blog  
 * File Name:BlogController.java  
 * Package Name:com.blog.controller  
 * Date:2016-8-12下午2:39:48  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.controller.supervisor;  


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.constants.Constants;
import com.blog.controller.BaseController;
import com.blog.entity.Blog;
import com.blog.entity.BlogTypes;
import com.blog.lucene.Index;
import com.blog.util.Convert;
import com.blog.util.DateUtil;
import com.blog.util.ErrorInfo;

/**  
 * ClassName:BlogController <br/>  
 * Function: 博客控制器. <br/>  
 * Date:     2016-8-12 下午2:39:48 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
@Controller
@RequestMapping("/supervisor")
public class BlogController extends BaseController{
	Logger logger = Logger.getLogger(BlogController.class);
	private Index index = new Index();
	/**
	 * submitBlog:(新增博客). <br/>   
	 * @author Administrator  
	 * @param request
	 * @return  
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping("/submit-blog")
	public ErrorInfo submitBlog(HttpServletRequest request) throws Exception{
		ErrorInfo error  = new ErrorInfo();
		String title = request.getParameter("title");
		String keyword = request.getParameter("keyword");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		int isUse = Convert.strToInt(request.getParameter("isUse"),-1);
		int blogType =Convert.strToInt(request.getParameter("blogType"),-1) ;
		int readCount = Convert.strToInt(request.getParameter("read_count"), 1);
		Date publish_time = DateUtil.strToSpecialDate(request.getParameter("publish_time")) ;
		
		if(isUse==-1 || blogType ==-1){
			error.code=-1;
			error.msg="blog保存失败！";
			return error;
		}
		
		Blog blog = new Blog();
		blog.setAuthor(author);
		blog.setBlog_type(blogType);
		blog.setContent(content);
		blog.setIs_use(isUse);
		blog.setKeyword(keyword);
		blog.setPublish_time(publish_time);
		blog.setTitle(title);
		blog.setRead_count(readCount);
		
		if(!blogServiceImpl.saveBlog(blog)){
			error.code=-1;
			error.msg="blog保存失败！";
		}else{
			index.index(Constants.INDEXDIR, blog);
		}
		
		return error;
	}
	
	//修改blog
	@ResponseBody
	@RequestMapping("submitupdate")
	public ErrorInfo submitUpdate(HttpServletRequest request){
		ErrorInfo error  = new ErrorInfo();
		long id = Convert.strToLong(request.getParameter("id"), -1);
		String title = request.getParameter("title");
		String keyword = request.getParameter("keyword");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		int isUse = Convert.strToInt(request.getParameter("isUse"),-1);
		int blogType =Convert.strToInt(request.getParameter("blogType"),-1) ;
		int readCount = Convert.strToInt(request.getParameter("read_count"), 1);
		Date publishTime = DateUtil.strToSpecialDate(request.getParameter("publish_time")) ;;
		
		if(id==-1||isUse==-1 || blogType ==-1){
			error.code=-1;
			error.msg="参数错误！";
			return error;
		}
		
		Blog blog = new Blog();
		blog.setId(id);
		blog.setAuthor(author);
		blog.setBlog_type(blogType);
		blog.setContent(content);
		blog.setIs_use(isUse);
		blog.setKeyword(keyword);
		blog.setPublish_time(publishTime);
		blog.setTitle(title);
		blog.setRead_count(readCount);
		
		try{
			int result=blogServiceImpl.updateBlog(blog);
			if(result<=0){
				error.code=-1;
				error.msg="blog保存失败！";
			}
		}catch(Exception e){
			error.code=-1;
			error.msg="blog保存失败！";
			e.printStackTrace();
		}
		
		return error;
	}
	
	/**
	 * deleteBlog:(删除博客). <br/>   
	 * @author Administrator  
	 * @param request
	 * @return  
	 * @since JDK 1.7
	 */
	@ResponseBody
	@RequestMapping("/delete-blog")
	public ErrorInfo deleteBlog(HttpServletRequest request){
		ErrorInfo error = new ErrorInfo();
		long id = Convert.strToLong(request.getParameter("bid"), -1);
		if(id==-1){
			error.code=-1;
			error.msg="参数错误！";
			return error;
		}
		
		try{
			
		    int result=blogServiceImpl.deleteBlog(id);
			if(result<=0){
				error.code=-1;
				error.msg="删除失败！";
			}
			
		}catch(Exception e){
			error.code=-1;
			error.msg="删除失败！";
			e.printStackTrace();
		}
		return error;
	}
	
	//修改类型信息
	@RequestMapping("/updateType")
	@ResponseBody
	public ErrorInfo updateType(HttpServletRequest request){
		ErrorInfo error = new ErrorInfo();
		long id = Convert.strToLong(request.getParameter("id"), -1);
		String name = request.getParameter("newType");
		if(id==-1){
			error.code=-1;
			error.msg="保存失败！";
			return error;
		}
		
		BlogTypes type = new BlogTypes();
		type.setId(id);
		type.setName(name);
		type.setIs_use(1);
		
		int result = blogTypesServiceImpl.updateType(type);
		if(result<=0){
			error.code=-1;
			error.msg="保存失败！";
		}
		return error;
	}
	
	//增加blog类型
	@RequestMapping("/addType")
	@ResponseBody
	public ErrorInfo addType(HttpServletRequest request){
		ErrorInfo error = new ErrorInfo();
		String name = request.getParameter("newType");
		BlogTypes type = new BlogTypes();
		type.setName(name);
		type.setIs_use(1);
		
		try{
			int result = blogTypesServiceImpl.addType(type);
			if(result<=0){
				error.code=-1;
				error.msg="新增失败！";
			}
		}catch(Exception e){
			error.code=-1;
			error.msg="新增失败！";
			e.printStackTrace();
		}
		return error;
	}
	
	/**
	 * toUpdateBlog:(修改博客页面). <br/>   
	 * @author Administrator  
	 * @return  
	 * @since JDK 1.7
	 */
	@RequestMapping("/update-blog")
	public String toUpdateBlog(long blogId,Model model){
		List<BlogTypes> types = blogTypesServiceImpl.getAllBlogTypes();
		Blog blog =blogServiceImpl.getBlogById(blogId);
		
		model.addAttribute("types", types);
		model.addAttribute("blog", blog);
		model.addAttribute("selected", 1);
		return "supervisor/blogMgt/updateBlog";
	}
	
	
}
  

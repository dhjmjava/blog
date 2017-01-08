/**  
 * Project Name:blog  
 * File Name:AdminController.java  
 * Package Name:com.blog.controller  
 * Date:2016年9月14日下午1:15:17  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.controller.supervisor;  

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
import com.blog.entity.Blogger;
import com.blog.util.Convert;
import com.blog.util.EncryptUtil;
import com.blog.util.ErrorInfo;
import com.blog.util.Page;

/**  
 * ClassName:AdminController <br/>  
 * Function: 后台管理控制器. <br/>  
 * Date:     2016年9月14日 下午1:15:17 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Controller
@RequestMapping("/supervisor")
public class IndexController extends BaseController{
	Logger logger = Logger.getLogger(IndexController.class);
	
	/**
	 * index:(后台首页). <br/>   
	 * @author Administrator  
	 * @return  
	 * @since JDK 1.6
	 */
	@RequestMapping("/index.html")
	public String index(HttpServletRequest request ,Model model){
		int currPage = Convert.strToInt(request.getParameter("currPage"), 1);
		int pageSize = Constants.TEN;
		
		List<BlogTypes> types = blogTypesServiceImpl.getAllBlogTypes();
		
		Page<Blog> page = null;
    	try {
    		page = blogServiceImpl.getBlogList(currPage,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		String userName = null;
		Object obj = session.getAttribute("userName");
		if(obj==null){
			return "supervisor/login";
		}else{
			userName=obj.toString();
		}
		
		model.addAttribute("userName", userName);
		model.addAttribute("page",page);
		model.addAttribute("types", types);
		model.addAttribute("selected", 1);
		
		return "supervisor/homeMgt/index";
	}
	
	//评论管理
	@RequestMapping("/commentMgt.html")
	public String commentMgt(Model model){
		List<Blog> blogs = blogServiceImpl.getBlogByComm();
		model.addAttribute("blogs", blogs);
		model.addAttribute("selected", 2);
		return "supervisor/commentMgt/commentMgt";
	}
	
	//系统管理
	@RequestMapping("/systemMgt.html")
	public String systemMgt(Model model){
		Blogger blogger=bloggerServiceImpl.getBloggerInfoById(1);
		model.addAttribute("blogger",blogger);
		model.addAttribute("selected", 4);
		return "supervisor/systemMgt/updateBloggerInfo";
	}
	
	@RequestMapping("/login.html")
	public String login(HttpServletRequest request,Model model){
    	return "supervisor/login";
    }
	
	/**
	 * checkLogin:(登录检查). <br/>   
	 * @author Administrator  
	 * @param request
	 * @param model
	 * @return  
	 * @since JDK 1.6
	 */
	@ResponseBody
	@RequestMapping("/checkLogin")
	public ErrorInfo checkLogin(HttpServletRequest request,Model model){
		ErrorInfo error = new ErrorInfo();
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		Blogger blogger =null;
		List<Blogger> bloggers=bloggerServiceImpl.getAllBlogger();
		if(bloggers != null && bloggers.size()!=0){
			blogger = bloggers.get(0);
		}
		if(username == null  || pwd == null){
			error.code=-1;
			error.msg="用户名或密码错误！";
		}
		if(username.equals(blogger.getUserName())){
			//密码解密
			String password=null;
			try {
				password = EncryptUtil.decrypt(blogger.getPassword());
			} catch (Exception e) {
				e.printStackTrace();  
			}
			
			if(pwd.equals(password)){
				error.code=1;
				error.msg="登录成功！";
				session.setAttribute("userName", username);
			}else{
				error.code=-1;
				error.msg="密码错误！";
			}
		}else{
			error.code=-1;
			error.msg="用户名错误！";
		}
	    return error;
	}
	
	//登录成功
	@RequestMapping("/loginSuccess")
	public String index(Model model,HttpServletRequest request){
		return "redirect:/index.html";
	}
	
	/**
	 * loginOut:(退出). <br/>   
	 * @author Administrator  
	 * @param request
	 * @since JDK 1.6
	 */
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request){
		session.removeAttribute("userName");
		return "redirect:/login.html";
	}
	
	//新增博客页面
	@RequestMapping("addBlog")
	public String addBlog(Model model){
		List<BlogTypes> types = blogTypesServiceImpl.getAllBlogTypes();
		model.addAttribute("types", types);
		model.addAttribute("selected", 1);
		return "supervisor/blogMgt/addBlog";
	}
	
	//类别管理页面
	@RequestMapping("typeMgt")
	public String typeMgt(Model model){
		List<BlogTypes> types = blogTypesServiceImpl.getAllBlogTypes();
		model.addAttribute("types", types);
		model.addAttribute("selected", 1);
		return "supervisor/blogMgt/typeMgt";
	}
	
}
  

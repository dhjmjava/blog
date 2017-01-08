/**  
 * Project Name:blog  
 * File Name:LinkController.java  
 * Package Name:com.blog.controller  
 * Date:2016年10月3日下午11:32:33  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.controller.supervisor;  

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.controller.BaseController;
import com.blog.entity.Link;
import com.blog.util.Convert;
import com.blog.util.ErrorInfo;

/**  
 * ClassName:LinkController <br/>  
 * Function: link控制器. <br/>  
 * Date:     2016年10月3日 下午11:32:33 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Controller
@RequestMapping("supervisor")
public class LinkController extends BaseController{
	
	@RequestMapping("/linkMgt.html")
	public String toLink(Model model){
		List<Link> links = linkServiceImpl.getLinkList();
		model.addAttribute("links", links);
		model.addAttribute("selected",3);
		return "supervisor/linkMgt/linkMgt";
	}
	
	@RequestMapping("addLink")
	public String addLink(Model model){
		model.addAttribute("selected",3);
		return "supervisor/linkMgt/addLink";
	}
	
	@RequestMapping("updateLink-{id}")
	public String updateLink(@PathVariable("id") Long id,HttpServletRequest request ,Model model){
		Link link = linkServiceImpl.getLinkById(id);
		model.addAttribute("link", link);
		return "supervisor/linkMgt/updateLink";
	}
	
	@RequestMapping("saveUpdate")
	@ResponseBody
	public ErrorInfo saveUpdate(HttpServletRequest request){
		ErrorInfo error = new ErrorInfo();
		
		long id = Convert.strToLong(request.getParameter("lid"), -1);
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		int is_use = Convert.strToInt(request.getParameter("is_use"),1);
		
		Link link = new Link();
		link.setId(id);
		link.setIs_use(is_use);
		link.setName(name);
		link.setUrl(url);
		link.setOrder(4);
		
		try {
			
			int result = linkServiceImpl.updateLink(link);
			
			if(result<=0){
				error.code=-1;
				error.msg="保存失败！";
			}
		} catch (Exception e) {
			error.code=-1;
			error.msg="保存失败！";
			e.printStackTrace();
		}
		
		return error;
	}
	
	@RequestMapping("/submit-link")
	@ResponseBody
	public ErrorInfo submitLink(HttpServletRequest request){
		ErrorInfo error = new ErrorInfo();
		
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		int is_use = Convert.strToInt(request.getParameter("is_use"),1);
		
		Link link = new Link();
		link.setIs_use(is_use);
		link.setName(name);
		link.setUrl(url);
		link.setOrder(4);
		
		try {
			
			int result = linkServiceImpl.addLink(link);
			
			if(result<=0){
				error.code=-1;
				error.msg="保存失败！";
			}
		} catch (Exception e) {
			error.code=-1;
			error.msg="保存失败！";
			e.printStackTrace();
		}
		
		return error;
		
	}
	
	@RequestMapping("/delete-link")
	@ResponseBody
	public ErrorInfo deleteLink(HttpServletRequest request){
	   ErrorInfo error = new ErrorInfo();
	   long id = Convert.strToLong(request.getParameter("lid"), -1);
	   
	   if(id<=0){
		   error.code=-1;
		   error.msg="删除失败！";
		   return error;
	   }
	   
	   try {
			   int result = linkServiceImpl.deleteLink(id);
			   if(result<=0){
				   error.code=-1;
				   error.msg="删除时出现错误！";
		   }
		
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	   
	   return error;	
	}

}
  

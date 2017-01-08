/**  
 * Project Name:blog  
 * File Name:SystemController.java  
 * Package Name:com.blog.controller.supervisor  
 * Date:2016年11月16日下午9:35:04  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.controller.supervisor;  

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.controller.BaseController;
import com.blog.entity.Blogger;
import com.blog.util.Convert;
import com.blog.util.ErrorInfo;

/**  
 * ClassName:SystemController <br/>  
 * Function: 博主信息设置. <br/>  
 * Date:     2016年11月16日 下午9:35:04 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Controller
@RequestMapping("supervisor")
public class SystemController extends BaseController{
	
	@RequestMapping("updateBloggerInfo")
	@ResponseBody
	public ErrorInfo updateBloggerInfo(HttpServletRequest request){
		ErrorInfo error = new ErrorInfo();
		long id = Convert.strToLong(request.getParameter("id"), -1);
		String name = request.getParameter("name");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String describe = request.getParameter("describe");
		String motto = request.getParameter("motto");
		
		Blogger blogger  = new Blogger();
		blogger.setId(id);
		blogger.setDescribe(describe);
		blogger.setName(name);
		blogger.setUserName(userName);
		blogger.setEmail(email);
		blogger.setMotto(motto);
		try {
		int result = bloggerServiceImpl.updateBloggerInfo(blogger);
		if(result<=0){
			error.code=-1;
			error.msg="保存失败！";
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return error;
	}

}
  

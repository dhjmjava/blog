/**  
 * Project Name:blog  
 * File Name:indexController.java  
 * Package Name:com.blog.controller  
 * Date:2016-8-11下午3:36:42  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.controller.front;  

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.blog.constants.Constants;
import com.blog.controller.BaseController;
import com.blog.entity.Blog;
import com.blog.entity.BlogComments;
import com.blog.entity.Blogger;
import com.blog.entity.Link;
import com.blog.lucene.Searcher;
import com.blog.util.Convert;
import com.blog.util.ErrorInfo;
import com.blog.util.Page;
import com.blog.util.StringEscapeEditor;

/**  
 * ClassName:indexController <br/>  
 * Function: 核心控制器. <br/>  
 * Date:     2016-8-11 下午3:36:42 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
@Controller
public class HomeController extends BaseController{
	Logger logger = Logger.getLogger(HomeController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	   binder.registerCustomEditor(String.class, new StringEscapeEditor(false, false, false));
	}

    @RequestMapping("/")
    public String home(Model model,HttpServletRequest request) {
    	
    	int currPage = Convert.strToInt(request.getParameter("currPage"), 1);
    	int pageSize = Constants.TEN;
    	long typeId = Convert.strToLong(request.getParameter("typeId"), -1);
    	String searchDate = request.getParameter("searchDate");
    	
    	Page<Blog> page = null;
    	try {
    		page = blogServiceImpl.getBlogPage(currPage,pageSize,typeId,searchDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	model.addAttribute("page", page);
        return "home";
    }
    
    //文章详情
    @RequestMapping("article-{bi}.html")
    public String blogInfo(@PathVariable("bi") long bi,Model model){
    	
    	Blog blog = blogServiceImpl.getBlogById(bi);
    	List<BlogComments> comments = blogCommentsServiceImpl.queryCommentsByBid(bi);
    	
    	model.addAttribute("blog",blog);
    	model.addAttribute("comments", comments);
    	return "front/blogInfo";
    }
    
    //关于博主
    @RequestMapping(value="aboutMe.html",method=RequestMethod.GET)
    public String aboutMe(Model model){
    	Blogger blogger=bloggerServiceImpl.getBloggerInfoById(1);
    	model.addAttribute("blogger", blogger);
        return "front/bloggerInfo";
    }
    
    //下载页面
    @RequestMapping(value="download.html",method=RequestMethod.GET)
    public String download(Model model,HttpServletRequest request){
        return "front/download";
    }
    
    /**
     * submitComment:(提交评论). <br/>   
     * @author Administrator  
     * @param request
     * @return  
     * @since JDK 1.7
     */
    @RequestMapping(value="submit-comment",method=RequestMethod.POST)
    @ResponseBody
    public ErrorInfo submitComment(HttpServletRequest request){
    	ErrorInfo error = new ErrorInfo();
    	String captchaCode = request.getParameter("captchaCode"); 
    	String content = request.getParameter("content");
    	String rands  = session.getAttribute("captcha").toString();
    	long blogId = Convert.strToLong(request.getParameter("blogId"), -1);
    	
    	if(null == captchaCode|| "".equals(captchaCode)){
    		error.code = -1;
    		error.msg = "请输入验证码！";
    		return error;
    	}else{
    		if(captchaCode.equalsIgnoreCase(rands)){
    		    error = blogCommentsServiceImpl.saveComment(content ,blogId ,request);
    		}else{
    			error.code = -1;
    			error.msg = "验证码错误，请重新输入！";
    		}
    	}
    	
    	return error;
    }
    
    /**
     * 
     * search:(搜索页面). <br/>   
     *  
     * @author daihui  
     * @param q
     * @param model
     * @param request
     * @return  
     * @since JDK 1.7
     */
    @RequestMapping(value="search",method=RequestMethod.GET)
    public String search(String q,Model model,HttpServletRequest request){
    	int currPage = Convert.strToInt(request.getParameter("currPage"), 1);
    	int pageSize = Constants.TEN;
    	
    	Page<Blog> page = new Page<Blog>();
	    try {
	    	page = Searcher.search(Constants.INDEXDIR, q);
	    	page.currPage=currPage;
	    	page.pageSize=pageSize;
	    	page.totalCount=page.page.size();
	    	page.page.subList(currPage-1,(currPage-1)*pageSize);
	    	page.setPageNumber(page.totalCount);
		} catch (Exception e) {
			e.printStackTrace();  
		}
	    
	    model.addAttribute("q", q);
	    model.addAttribute("page", page);
	    
	    return "front/search";
    }
    
    /**
	 * 
	 * common:(公共页面数据). <br/>   
	 *  
	 * @author Administrator  
	 * @return  
	 * @since JDK 1.7
	 */
	@RequestMapping(value= "/common",  method = RequestMethod.GET)
	@ResponseBody
	public String common(HttpServletRequest request){
		int currPage = Convert.strToInt(request.getParameter("currPage"), 1);
    	long typeId = Convert.strToLong(request.getParameter("typeId"), -1);
    	String searchDate = request.getParameter("searchDate");
		
    	List<Link> links = linkServiceImpl.getLinkList();
    	List<Blog> blogDate = blogServiceImpl.getBlogDate();
    	List<Blog> typeBlogs = blogServiceImpl.getBlogType();
    	Map<String, Object> map = new HashMap<String, Object>();
    	Blogger blogger=bloggerServiceImpl.getBloggerInfoById(1);
    	map.put("blogger", blogger);
    	map.put("links", links);
    	map.put("blogDate", blogDate);
    	map.put("typeBlogs", typeBlogs);
    	map.put("currPage", currPage);
    	map.put("typeId", typeId);
    	map.put("searchDate", searchDate);
    	String json = JSON.toJSONString(map); 
    	return json;
	}
    
}
  

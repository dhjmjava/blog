/**  
 * Project Name:blog  
 * File Name:MyStartupRunner.java  
 * Package Name:com.blog.config  
 * Date:2016年12月27日下午11:41:37  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.config;  

import java.io.File;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blog.constants.Constants;
import com.blog.controller.BaseController;
import com.blog.entity.Blog;
import com.blog.lucene.Index;
import com.blog.service.BaseService;
import com.blog.service.impl.BlogServiceImpl;

/**  
 * ClassName:MyStartupRunner <br/>  
 * Function: 系統啟動初始化索引. <br/>  
 * Date:     2016年12月27日 下午11:41:37 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Component
public class MyStartupRunner extends BaseService implements CommandLineRunner{

	/*
	 * 系統啟動初始化索引（可选）.  
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... arg0) throws Exception {
		File file = new File(Constants.INDEXDIR);
		if(!file.exists()){
			file.mkdirs();
			if(file.listFiles().length<=0){
				List<Blog> blogs =   blogMapper.getAll();
				new Index().initIndex(Constants.INDEXDIR, blogs);
			}
		}
	}

}
  

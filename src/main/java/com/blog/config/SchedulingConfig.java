/**  
 * Project Name:blog  
 * File Name:SchedulingConfig.java  
 * Package Name:com.blog.config  
 * Date:2016年9月27日下午12:58:59  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.config;  

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**  
 * ClassName:SchedulingConfig <br/>  
 * Function: 定时任务. <br/>  
 * Date:     2016年9月27日 下午12:58:59 <br/>  
 * @author   Administrator  
 * @since    JDK 1.6  
 */
@Configuration
@EnableScheduling //启用定时任务
public class SchedulingConfig {
	
	Logger logger= Logger.getLogger(SchedulingConfig.class);
	
	//@Scheduled(cron = "0/20 * * * * ?") // 每20秒执行一次
	public void test(){
		System.out.println("定时任务开始执行！");
		System.out.println("定时任务！");
		System.out.println("定时任务执行！");
		System.out.println("定时任务！");
	}

}
  

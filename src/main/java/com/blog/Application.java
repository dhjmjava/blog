package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**  
 * ClassName:Application <br/>  
 * Function: 程序入口. <br/>  
 * Date:     2016-8-11 下午12:00:16 <br/>  
 * @author   Administrator  
 * @since    JDK 1.6  
 */

@Configuration// 配置控制
@ComponentScan// 组件扫描
@EnableAutoConfiguration// 启用自动配置
@EnableTransactionManagement//开启事务
public class Application extends SpringBootServletInitializer{

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Application.class); 
        application.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
  

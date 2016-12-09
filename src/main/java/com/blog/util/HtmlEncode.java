/**  
 * Project Name:blog  
 * File Name:HtmlEncode.java  
 * Package Name:com.blog.util  
 * Date:2016年11月9日上午12:18:00  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.util;  

import java.util.Set;
import java.util.regex.Pattern;

/**  
 * ClassName:HtmlEncode <br/>  
 * Function: 防注入，以及关键词过滤. <br/>  
 * Date:     2016年11月9日 上午12:18:00 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class HtmlEncode {
	
	public static String htmlEncode(String string) {  
        if(null == string || "".equals(string))  
            return null;  
        else{  
            String result = string;  
            result = result.replaceAll("&", "&");  
            result = result.replaceAll("<", "<");  
            result = result.replaceAll(">", ">");  
            result = result.replaceAll("\"", "'");  
            return (result.toString());  
        }  
    }  
    public static String htmlDecode(String string) {  
        if(null == string || "".equals(string))  
            return null;  
        else{  
            String result = string;  
            result = result.replaceAll("&", "&");  
            result = result.replaceAll("<", "<");  
            result = result.replaceAll(">", ">");  
            result = result.replaceAll("'", "\"");  
            return (result.toString());  
        }  
    }    
    
    private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"  
            + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute|UNION|EXISTS)\\b)";  
  
    private static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);  
  
    //sql关键字过滤
    public static boolean isValid(String str) {  
    if (sqlPattern.matcher(str).find()) {  
           return true; 
       }  
         return false; 
     }  

    //敏感词过滤
    public static boolean filterWord(String content){
    	boolean flag = false;
    	SensitivewordFilter filter = new SensitivewordFilter();
    	Set<String> set = filter.getSensitiveWord(content, 1);
    	if(set.size()>0){
    		flag = true;
    	}
    	return flag;
    }
}
  

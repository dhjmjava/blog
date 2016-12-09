/**  
 * Project Name:blog  
 * File Name:StringEscapeEditor.java  
 * Package Name:com.blog.util  
 * Date:2016年11月9日上午12:24:21  
 * Copyright (c) 2016, jingmendh@163.com All Rights Reserved.  
 *  
*/  
  
package com.blog.util;  

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringEscapeUtils;

/**  
 * ClassName:StringEscapeEditor <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2016年11月9日 上午12:24:21 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class StringEscapeEditor extends PropertyEditorSupport{

	private boolean escapeHTML;
	private boolean escapeJavaScript;
	private boolean escapeSQL;
	public StringEscapeEditor() { super(); }
	public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript, boolean escapeSQL) {
		super();
		this.escapeHTML = escapeHTML;
		this.escapeJavaScript = escapeJavaScript;
		this.escapeSQL = escapeSQL;
	}
	@Override
	public void setAsText(String text) {
	if (text == null) {
	
		setValue(null);
	
	} else {
		
	String value = text;
	if (escapeHTML) { 
		value = StringEscapeUtils.escapeHtml3(value);
	   }
	if (escapeJavaScript) { 
		 value =StringEscapeUtils.escapeEcmaScript(value); 
		}
	if (escapeSQL) { 
		 value = StringEscapeUtils.escapeJava(value);
	    }
	
	  setValue(value); }
	}
	@Override
	public String getAsText() { 
		
		Object value = getValue(); 
		return value!= null ? value.toString() :"";
		
	}
	
}
  

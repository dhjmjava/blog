package com.blog.entity;public class BlogTypes implements java.io.Serializable {	/**  	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).  	 * @since JDK 1.6  	 */	 	private static final long serialVersionUID = -8436758490590285623L;	private long id;	private String name;	private int is_use;	private String describe;	private int order;	public BlogTypes(){}	public BlogTypes(long id, String name, int is_use, String describe, int order) {		super();		this.id = id;		this.name = name;		this.is_use = is_use;		this.describe = describe;		this.order = order;	}	public long getId() {		return id;	}	public void setId(long id) {		this.id = id;	}	public String getName() {		return name;	}	public void setName(String name) {		this.name = name;	}	public int getIs_use() {		return is_use;	}	public void setIs_use(int is_use) {		this.is_use = is_use;	}	public String getDescribe() {		return describe;	}	public void setDescribe(String describe) {		this.describe = describe;	}	public int getOrder() {		return order;	}	public void setOrder(int order) {		this.order = order;	}	}
package com.puzzle.core.page;

import java.util.HashMap;

/**
 * 分页实体，包含分页参数和结果集
 * 
 * @author Song
 * 2018年1月8日
 */
public class Page {
	
	public static final String ASC = "asc";
	public static final String DESC = "desc";
	public static final int DEFAULT_PAGE_SIZE = 10;
	
	private Object result = new HashMap();

}

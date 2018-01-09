package com.puzzle.core.page;

import java.util.ArrayList;


/**
 * 分页实体，包含分页参数和结果集
 * Page构造方法初始化result和totalCount
 * setPageNo
 * setPageSize 同时初始化totalPageCount
 * 
 * @author Song
 * 2018年1月8日
 */
public class Page {
	
	public static final String ASC = "asc";
	
	public static final String DESC = "desc";
	
	public static final int DEFAULT_PAGE_SIZE = 20;
	
	//封装结果集
	private Object result = new ArrayList();
	
	//当前页号
	private long pageNo = 1;
	
	//每页记录数
	private long pageSize = DEFAULT_PAGE_SIZE;
	
	//总记录数
	private long totalCount;
	
	//总页数
	private long totalPageCount;
	
	//排序字段
	private String orderBy = "";
	
	//排序顺序
	private String orders = this.ASC;
	
	//上一页
	private boolean hasPrevious;
	
	//下一页
	private boolean hasNext;

	public Page(Object result, long totalCount) {
		super();
		this.result = result;
		this.totalCount = totalCount;
	}
	
	public Page() {
		super();
	}

	//计算是否有上一页下一页
	
	//计算totalPageCount,是否有上一页，下一页
	
	//hasPreviousEnable()
	
	//hasNextEnabled()

	/** getter and setter */
	
	public Object getResult() {
		return result;
	}

	public long getPageNo() {
		return pageNo;
	}

	public long getPageSize() {
		return pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public long getTotalPageCount() {
		return totalPageCount;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getOrders() {
		return orders;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPageCount(long totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	
}

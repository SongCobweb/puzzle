package com.puzzle.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * 通用数据访问接口
 * declare Generic Base methods for DAO
 * 声明数据访问的基础方法
 * 
 * @author songwenquan
 *
 */
public interface GenericDao<T> {

	<T> T get(Class<T> entityClass, Serializable id);
	
	<T> T load(Class<T> entityClass, Serializable id);
	
	<T> List<T> getAll(Class<T> entityClass);
	
	<T> List<T> getAll(Class<T> entityClass, String orderBy, boolean isAsc);
	
	void insert(Object entity);
	
	void update(Object entity);
	
	void remove(Object entity);
	
	void removeById(Class<T> entityClass, Serializable id);
	
	void removeAll(Collection<T> collection);
	
	void removeAll(Class<T> entityClass);
	
	Integer count(Class<T> entityClass);
	
	Serializable getId(Class<T> entityClass, Object entity);
	
	void setId(Class<T> entityClass, Object entity, Serializable id);
	
	void flush();
	
	void clear();
	
	void evict();
	
	void initialize();
}

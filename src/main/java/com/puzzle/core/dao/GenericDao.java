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
public interface GenericDao {

	<T> T get(Class<T> entityClass, Serializable id);
	
	<T> T load(Class<T> entityClass, Serializable id);
	
	<T> List<T> getAll(Class<T> entityClass);
	
	<T> List<T> getAll(Class<T> entityClass, String orderBy, boolean isAsc);
	
	Serializable save(Object entity);
	
	void insert(Object entity);
	
	void update(Object entity);
	
	void remove(Object entity);
	
	<T> void removeById(Class<T> entityClass, Serializable id);
	
	<T> void removeAll(Collection<T> collection);
	
	<T> void removeAll(Class<T> entityClass);
	
	<T> Integer count(Class<T> entityClass);
	
	<T> Serializable getId(Class<T> entityClass, Object entity);
	
	<T> void setId(Class<T> entityClass, Object entity, Serializable id);
	
	void flush();
	
	void clear();
	
	void evict(Object entity);
	
	void initialize(Object entity);
	
	/**
	 * Query接口方法（执行HQL语句）
	 */
	
	/**
	 * SQL查询借口
	 */
	
	/**
	 * SQL增删改接口，需要声明式事务
	 */
	
}

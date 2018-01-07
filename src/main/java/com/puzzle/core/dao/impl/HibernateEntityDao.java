package com.puzzle.core.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 重写需要业务逻辑的方法，增加泛型对象，然后调用父类基础方法实现
 * 这个为最终dao实现
 * @author songwenquan
 *
 * @param <T>
 */
public class HibernateEntityDao<T> extends HibernatePageDao{

	/** Logger */
	private static Logger logger = LoggerFactory.getLogger(HibernateEntityDao.class);
	
	/** 持久化对象 */
	private Class<T> entityClass;

	/** 构造方法 */
	public HibernateEntityDao(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	/**    set and get 方法   */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	
	
	
}

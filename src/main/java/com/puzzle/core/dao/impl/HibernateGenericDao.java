package com.puzzle.core.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.puzzle.core.dao.GenericDao;

/**
 * 提供基础方法实现的Hibernate Dao基类
 * 
 * @author songwenquan
 *
 */
@Transactional
public class HibernateGenericDao<T> implements GenericDao<T> {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

}

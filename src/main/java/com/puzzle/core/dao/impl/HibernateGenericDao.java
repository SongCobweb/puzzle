package com.puzzle.core.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.puzzle.core.dao.GenericDao;
import com.puzzle.core.id.IdGenerator;

/**
 * 提供基础方法实现的Hibernate Dao基类
 * 
 * @author songwenquan
 *
 */
@Transactional
public class HibernateGenericDao<T> implements GenericDao<T> {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** IdGenerator */
	private IdGenerator idGenerator;
	
	/** SessionFactory */
	private SessionFactory sessionFactory;
	
	/** JdbcTemplate */
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * ============================
	 *        constructor
	 * ============================
	 */
	public HibernateGenericDao() {
		super();
	}

	/**
	 * ============================
	 *        constructor
	 * ============================
	 */
	public HibernateGenericDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public IdGenerator getIdGenerator() {
		return idGenerator;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	// ---------------------------------------- //
	// -------------  Autowired  -------------- //
	// ---------------------------------------- //
	@Resource
	public void setIdGenerator(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	
}

package com.puzzle.core.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

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

	@Transactional(readOnly = true)
	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public <T> T load(Class<T> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public <T> List<T> getAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public <T> List<T> getAll(Class<T> entityClass, String orderBy,
			boolean isAsc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void insert(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void remove(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void removeById(Class<T> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void removeAll(Collection<T> collection) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void removeAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(readOnly = true)
	@Override
	public Integer count(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getId(Class<T> entityClass, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Class<T> entityClass, Object entity, Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evict() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}

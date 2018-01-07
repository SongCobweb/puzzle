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
public abstract class HibernateGenericDao implements GenericDao {
	
	protected static Logger logger = LoggerFactory.getLogger(HibernateGenericDao.class);
	
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
	
	//---------------------------------------------------//
	//---------------------------------------------------//
	//---------------------------------------------------//
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
		return this.getSession().createCriteria(entityClass).list();
	}

	@Transactional(readOnly = true)
	@Override
	public <T> List<T> getAll(Class<T> entityClass, String orderBy,
			boolean isAsc) {
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
	public <T> void removeById(Class<T> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public <T> void removeAll(Collection<T> collection) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public <T> void removeAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(readOnly = true)
	@Override
	public <T> Integer count(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Serializable getId(Class<T> entityClass, Object entity) {
		//通过Class对象获得主键字段名称
		
		//获取主键字段的get方法
		
		//获取值
		return null;
	}

	@Override
	public <T> void setId(Class<T> entityClass, Object entity, Serializable id) {
		//通过Class对象获得主键字段名称
		
		//获取主键字段的set方法
		
		//执行反射方法，设置id值
	}
	
	/**
	 * 通过传入class对象获取目标对象的主键名称，获取主键字段名称
	 * @param entityClass
	 * @return
	 */
	public <T> String getIdName(Class<T> entityClass) {
		
		return null;
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

package com.puzzle.core.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.puzzle.core.dao.GenericDao;
import com.puzzle.core.id.IdGenerator;
import com.puzzle.utils.StringUtils;

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
	/**
	 * 实时加载，如果id不存在，会返回NullPointException
	 */
	@Transactional(readOnly = true)
	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		Assert.notNull(id, "id can not be null");
		return this.getSession().get(entityClass, id);
	}

	/**
	 * 延时加载，返回代理对象，具体使用时进行查询，对象不存在返回ObjectNotFoundException
	 */
	@Transactional(readOnly = true)
	@Override
	public <T> T load(Class<T> entityClass, Serializable id) {
		Assert.notNull(id, "id can not be null");
		return this.getSession().load(entityClass, id);
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
		//判断orderBy 字段是否为空
		if(StringUtils.isNotEmpty(orderBy)){
			Criteria criteria = this.getSession().createCriteria(entityClass);
			if(isAsc){
				criteria.addOrder(Order.asc(orderBy));
			}else{
				criteria.addOrder(Order.desc(orderBy));
			}
			return criteria.list();
		}else{
			return this.getAll(entityClass);
		}
	}

	@Transactional
	@Override
	public Serializable save(Object entity) {
		Assert.notNull(entity, "entity can not be null");
		return this.getSession().save(entity);
	}
	
	@Transactional
	@Override
	public void insert(Object entity) {
		Assert.notNull(entity, "entity can not be null");
		this.getSession().saveOrUpdate(entity);
	}

	@Transactional
	@Override
	public void update(Object entity) {
		Assert.notNull(entity, "entity can not be null");
		this.getSession().update(entity);
	}

	@Transactional
	@Override
	public void remove(Object entity) {
		Assert.notNull(entity, "entity can not be null");
		this.getSession().remove(entity);
	}

	@Transactional
	@Override
	public <T> void removeById(Class<T> entityClass, Serializable id) {
		Assert.notNull(id, "id can not be null");
		this.getSession().remove(this.get(entityClass, id));
	}

	@Transactional
	@Override
	public <T> void removeAll(Collection<T> collection) {
		Assert.notNull(collection, "collection can not be null");
		for(Object obj : collection){
			this.remove(obj);
		}
	}

	@Transactional
	@Override
	public <T> void removeAll(Class<T> entityClass) {
		this.removeAll(this.getAll(entityClass));
		
	}

	@Transactional(readOnly = true)
	@Override
	public <T> Integer count(Class<T> entityClass) {
		//查询集合后返回size
		
		//定义Query语句查询对应的表，反射出类名，查询count
		
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

	/** 将session中的数据flush到DB中 */
	@Override
	public void flush() {
		this.getSession().flush();
	}

	/** 清空session */
	@Override
	public void clear() {
		this.getSession().clear();
	}

	/** session中移除对象 */
	@Override
	public void evict(Object entity) {
		this.getSession().evict(entity);
	}

	/** 暴力initialize数据,解决load内属性对象的lazy异常 */
	@Override
	public void initialize(Object entity) {
		Hibernate.initialize(entity);
	}
	
	
}

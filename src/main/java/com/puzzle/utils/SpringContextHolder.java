package com.puzzle.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 静态持有SpringContext获取容器bean
 * 
 * @author Song
 * 2018年1月3日
 */
public class SpringContextHolder implements ApplicationContextAware, DisposableBean{
	
	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
		logger.debug("SpringContextHolder 注入ApplicationContext实例:{}", applicationContext);
	}
	
	/**
	 * 获取applicationContext静态实例
	 * @return
	 */
	public static ApplicationContext getApplicationContext(){
		checkApplicationContext();
		return applicationContext;
	}
	
	/**
	 * Validate.validState()校验
	 */
	public static void checkApplicationContext(){
		if(applicationContext == null){
			logger.error("applicationContext未注入，请在ApplicationContext.xml定义SpringContextHolder");
			throw new IllegalStateException("applicationContext未注入，请在ApplicationContext.xml定义SpringContextHolder");
		}
	}

	@Override
	public void destroy() throws Exception {
		SpringContextHolder.clearHolder();
	}
	
	/**
	 * 清除applicationContext持有的bean实例
	 */
	public static void clearHolder(){
		logger.debug("清除SpringContextHolder中的bean");
		applicationContext = null;
	}
	
	/**
	 * 取得静态变量中的bean，自动转型为T
	 * @param beanName
	 */
	public static <T> T getBean(String beanName){
		checkApplicationContext();
		return (T)applicationContext.getBean(beanName);
	}
	
	/**
	 * 取得静态变量中的bean，自动转型为T
	 * @return
	 */
	public static <T> T getBean(Class<T> entityClass){
		checkApplicationContext();
		return (T)applicationContext.getBean(entityClass);
	}

}

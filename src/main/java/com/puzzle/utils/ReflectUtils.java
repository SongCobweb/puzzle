package com.puzzle.utils;

import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * 反射工具类
 * 
 * @author Song
 * 2018年1月2日
 */
public class ReflectUtils{

	/**
	 * Class对象 - 类名 - modifier
	 */
	@Test
	public void test1(){
		//类名.class
		Class classEntity = BeanUtils.class;
		System.out.println(classEntity.getName());
		//对象.getClass（）
		BeanUtils beanUtils = new BeanUtils();
		classEntity = beanUtils.getClass();
		System.err.println(classEntity.getSimpleName());
		//Class.forName()
		try {
			Class classEntity2 = Class.forName("com.puzzle.utils.BeanUtils");
			System.out.println(classEntity2.getSuperclass().getName() + ":superClassName");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(classEntity.getModifiers());
		System.out.println(Modifier.isPublic(classEntity.getModifiers()));
		System.out.println(Modifier.isAbstract(classEntity.getModifiers()));
	}
}

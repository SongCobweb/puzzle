package com.puzzle;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

public class HelloWorld {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) throws InterruptedException {
		HelloWorld helloWorld = new HelloWorld();
		System.out.println(helloWorld.getClass());
		
	}
	
	@Test
	public void test01() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println(jedis.ping());
	}
}

package com.puzzle;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

public class HelloWorld {
	protected static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

	public static void main(String[] args) throws InterruptedException {
		
		
	}
	
	@Test
	public void test01() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println(jedis.ping());
	}
}

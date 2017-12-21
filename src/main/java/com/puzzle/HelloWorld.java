package com.puzzle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	protected static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

	public static void main(String[] args) throws InterruptedException {
		
		Thread.sleep(1000L);
		for(int i = 0; i <= 10000; i++){
			logger.info("before");
			System.out.println("HelloWorld");
			logger.info("after");
			logger.error("error");
		}
	}
}

package com.puzzle.core.id;

import java.util.UUID;


/**
 * ID=currentTimeMillis + (机器标识) + 线程标识 + UUID
 * org.apache.commons.codec.digest.DigestUtils.md5Hex()加密
 * 
 * @author Song
 * 2017年12月27日
 */

public class WrappedIdGenerator implements IdGenerator {

	@Override
	public String nextId() {
		return this.generateId();
	}
	
	/**
	 * 生成唯一标识
	 * @return
	 */
	private synchronized String generateId(){
		return timeGen() + threadGen() + UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * (2017-1970) * 365 *24 * 60 * 60 *1000
	 */
	String timeGen(){
		return Long.valueOf(System.currentTimeMillis()).toString();
	}
	
	String threadGen(){
		return Long.valueOf(Thread.currentThread().getId()).toString();
	}

	
	public static void main(String[] args) {
		IdGenerator idGenerator = new WrappedIdGenerator();
		int i = 0;
		while (true) {
			i++;
			System.out.println(idGenerator.nextId() + "================ ：" + i);
		}
	}
	
}

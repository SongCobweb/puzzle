package com.puzzle.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {

	@Test
	public void test01(){
		System.out.println("redis test");
	}
	
	@Test
	public void test02(){
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println(jedis.ping());
		System.out.println("-------------hash------------");
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key2", "value2-1");
		jedis.hmset("part1", map);
		for(Entry<String, String> entry : jedis.hgetAll("part1").entrySet()){
			System.err.println("key:" + entry.getKey() );
			System.err.println("value:" + entry.getValue());
		}
	}
	
	@Test
	public void test03(){
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println(jedis.ping());
		jedis.lpush("part12", "1");
		jedis.lpush("part12", "2");
		jedis.lpush("part12", "3");
//		jedis.lpush("part1", "1", "2", "12");
		jedis.lpush("part22", "1", "2", "12");
		List<String> list = jedis.lrange("part12", 0, 15);
		if(list != null && list.size() > 0){
			for(String str : list){
				System.out.println(str);
			}
		}
	}
	
	@Test
	public void test04(){
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("k1", "v1");
		jedis.set("k1", "v2");
		System.out.println(jedis.get("k1"));
	}
	
	@Test
	public void test05(){
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		
		jedis.sadd("windows", "ie6");
		jedis.sadd("windows", "ie8");
		jedis.sadd("windows", "ie edge");
		Set<String> set = jedis.smembers("windows");
		for(String str : set){
			System.out.println(str);
		}
	}
	
	@Test
	public void test06(){
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		Map<String, Double> sortMap = new HashMap<String, Double>();
		sortMap.put("ie 6", 1D);
		sortMap.put("ie edge", 3D);
		sortMap.put("ie 7", 2D);
		sortMap.put("ie 8", 2D);
		jedis.zadd("gu", sortMap);
		Set<String> set = jedis.zrange("gu", 0, 3);
		for(String s : set){
			System.out.println(s);
		}
	}
}

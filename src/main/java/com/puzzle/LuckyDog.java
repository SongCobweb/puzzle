package com.puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyDog {

	public static List<String> generationDogs(){
		List<String> list = new ArrayList<String>(14);
		list.add("良良");
		list.add("马日");
		list.add("小俊");
		list.add("深圳的夹子");
		list.add("雷子");
		list.add("有帅");
		list.add("大头");
		list.add("沛公");
		list.add("宗日");
		list.add("46");
		list.add("江斌");
		list.add("智茂");
		list.add("涛哥");
		list.add("权日");
		return list;
	}
	
	/**
	 * 生成0-13随机数
	 */
	public static Integer[] generationRandom(int count){
		List<Integer> list = new ArrayList<Integer>(count);
		for(int i=1;i<=count;i++){
			list.add((int)Math.round(Math.random()*13));
		}
		return list.toArray(new Integer[count]);
	}
	
	public static void main(String[] args) {
		//抽几个人
		System.err.println("选择抽奖的人数");
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		if(count<1 || count > 14){
			System.err.println("抽几把抽");
		}else{
			Integer[] ints = generationRandom(count);
			//抽奖集合
			List<String> dogs = generationDogs();
			System.out.println("鸡排群：本次抽奖抽中的" + count + "位选手是：");
			for(Integer integer : ints){
				System.out.println(dogs.get(integer));
			}
		}
		
		
	}
}

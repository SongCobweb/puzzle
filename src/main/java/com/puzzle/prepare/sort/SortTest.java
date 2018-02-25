package com.puzzle.prepare.sort;

import org.junit.Test;

/**
 * 排序算法单元测试
 * @author Song
 * 2018年2月23日
 */
public class SortTest {

	public int[] arr = {1,3,2,9,4,7,5,0};
	
	/**
	 * 冒泡排序 Bubble Sort
	 */
	@Test
	public void test1(){
		int length = arr.length;
		for(int i=0; i < length; i++){
			for(int j=0; j < length-i-1; j++){
				if(arr[j] > arr[j+1]){
					int x = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = x;
				}
			}
			printArray(arr);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}
	
	/**
	 * 冒泡排序改进Bubble Sort
	 */
	@Test
	public void test2(){
		int low = 0;
		int high = arr.length - 1;
		while(low < high){
			for(int j=low; j<high; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			high--;
			for(int j=high; j>low; j--){
				if(arr[j] < arr[j-1]){
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
			low++;
		}
		printArray(arr);
	}
	
	/**
	 * 选择排序Selection Sort
	 */
	@Test
	public void test3(){
		for(int i=0; i<arr.length-1; i++){
			int mod = i;
			for(int j=i+1; j<arr.length; j++){
				if(arr[j] < arr[mod]){
					mod = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[mod];
			arr[mod] = temp;
		}
		printArray(arr);
	}
	
	/**
	 * 插入排序 Insertion Sort
	 */
	@Test
	public void test4(){
		
	}
	
	public void printArray(int[] arr){
		if(arr != null && arr.length > 0){
			for(int i : arr){
				System.err.print(i + ",");
			}
		}else{
			return;
		}
	}
}

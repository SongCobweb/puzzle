package com.puzzle;


import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




public class LuckyDog {
	
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		System.out.println(System.currentTimeMillis());
		System.out.println("1514348522685".length());
	}
}

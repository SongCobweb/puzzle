package com.puzzle.test;

import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args) {
		String string = "1,s,gw,g,we,g,,";
		String[] strings = string.split(".", -1);
		for(String s : strings) {
			System.out.println(s);
		}
		System.out.println(string.length());
		System.out.println(strings.length);
	}
}

package com.puzzle.nio;


import java.nio.ByteBuffer;

import org.junit.*;

public class NioTest {

	@Test
	public void test1(){
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put((byte)110);
		buffer.rewind();
		System.out.println(buffer.position());
		buffer.put((byte)111);
		System.out.println(buffer.position());
		System.out.println(buffer.get(0));
	}
}

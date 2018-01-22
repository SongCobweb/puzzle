package com.puzzle.nio;

import java.nio.ByteBuffer;

import org.junit.Test;

public class NioTest {

	
	@Test
	public void test1() {
		//构建1024字节大小的ByteBuffer
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		buffer.put((byte) 99);
		buffer.put((byte) 20);
		
		System.out.println(buffer.get(1));
	}
}

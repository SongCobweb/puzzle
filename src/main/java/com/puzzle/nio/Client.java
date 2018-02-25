package com.puzzle.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * nio Client端
 * @author songwenquan
 *
 */
public class Client {

	public static void main(String[] args) {
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			System.out.println("socketChannel connection status : " + socketChannel.isConnected());
			socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));
			System.err.println("after connection socketChannel status is connect:" + socketChannel.isConnected());
			
			// out
			ByteBuffer buffer = ByteBuffer.allocate(256); 
			buffer.put("hello world".getBytes());
			buffer.flip();
			socketChannel.write(buffer);
			
			//in
			buffer = ByteBuffer.allocate(100);
			socketChannel.read(buffer);
			//处理buffer中的数据
			buffer.flip();
			System.out.println("========= 来自server的消息：===========");
			while(buffer.hasRemaining()) {
				System.out.println((char)buffer.get());
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				socketChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}

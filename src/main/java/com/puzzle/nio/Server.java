package com.puzzle.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * nio server 端
 * @author songwenquan
 *
 */
public class Server {
	
	public static void main(String[] args) {
		ServerSocketChannel serverSocketChannel = null ;
		SocketChannel socketChannel = null;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
			socketChannel = serverSocketChannel.accept();
			
			//in
			System.out.println("======来自Client的消息： ==========");
			ByteBuffer buffer = ByteBuffer.allocate(256);
			socketChannel.read(buffer);
			buffer.flip();
			while(buffer.hasRemaining()) {
				System.out.println((char)buffer.get());
			}
			//out
			buffer = ByteBuffer.allocate(100);
			buffer.put("I'm server , good evening".getBytes());
			buffer.flip();
			socketChannel.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				socketChannel.close();
				serverSocketChannel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

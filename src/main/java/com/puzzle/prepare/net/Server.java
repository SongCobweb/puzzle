package com.puzzle.prepare.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket Server
 * @author Song
 * 2018年2月23日
 */
public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(8000));
			Socket socket = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

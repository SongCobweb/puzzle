package com.puzzle.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import org.junit.*;

public class NioTest {

	@Test
	public void test1(){
		String pathname = "D:/000081620170706175632CLQY";
		try {
			RandomAccessFile file = new RandomAccessFile(pathname, "rw");
			FileChannel fileChannel = file.getChannel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

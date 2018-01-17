package com.puzzle.nio;

public class RunnableDemo implements Runnable{
	
	Thread thread ;
	String threadName ;
	
	public RunnableDemo(String threadName) {
		System.out.println("Thread " + threadName + " create");
		this.threadName = threadName;
	}

	public RunnableDemo() {
		
	}

	@Override
	public void run() {
		System.out.println("Thread " + threadName + " running");
		for(int i=0; i<=20;i++){
			System.err.println("Thread " + threadName + "--------------" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start(){
		
		System.out.println("Thread " + threadName + " start");
		if(thread == null){
			thread = new Thread(this, threadName);
		}
		thread.start();
	}
	
	public static void main(String[] args) {
		RunnableDemo r1 = new RunnableDemo("r1");
		r1.start();
		
		RunnableDemo r2 = new RunnableDemo("r2");
		r2.start();
	}

}

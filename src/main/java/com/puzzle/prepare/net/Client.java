package com.puzzle.prepare.net;


/**
 * Socket Client
 * @author Song
 * 2018年2月23日
 */
public class Client {

	private static ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			//super.initialValue()
			return 0;
		}
	};
	
	public int nextCount(){
		count.set(count.get() + 1);
		return count.get();
	}
	
	private static class CountThread extends Thread{
		
		private Client client;
		
		public CountThread(Client client){
			this.client = client;
		}

		@Override
		public void run() {
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName() + "count = " + client.nextCount());
			}
		}
		
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		CountThread thread1 = new CountThread(client);
		CountThread thread2 = new CountThread(client);
		CountThread thread3 = new CountThread(client);
		CountThread thread4 = new CountThread(client);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
}

package lyc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockDemo {

	private static Lock lock = new ReentrantLock();
	
	static class ThreadA extends Thread{
		@Override
		public void run() {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+"A");
			for (int i = 0; i < 10;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
			lock.unlock();
		}
	}
	static class ThreadB extends Thread{
		@Override
		public void run() {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+"B");
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		
		
		new ThreadB().start();
		new ThreadA().start();
	}
}

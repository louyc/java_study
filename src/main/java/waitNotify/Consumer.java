package waitNotify;

import java.util.Vector;

public class Consumer extends Thread{

	private final Vector sharedQueue;
	private final int size;
	
	public Consumer(Vector sharedQueue, int size) {
		super();
		this.sharedQueue = sharedQueue;
		this.size = size;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		while(true) {
			try {
				System.out.println("consumer"+consumer());
				Thread.sleep(50);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private int  consumer() throws InterruptedException {
		while(sharedQueue.isEmpty()) {
			synchronized (sharedQueue) {
				System.out.println("queue  is empty");
				sharedQueue.wait();
			}
		}
		synchronized (sharedQueue) {
			sharedQueue.notifyAll();
			return (int)sharedQueue.remove(0);
		}
	}
}

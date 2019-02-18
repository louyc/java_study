package waitNotify;

import java.util.Vector;

public class Producer implements Runnable{

	private final Vector sharedQueue;
	private final int size;
	
	public Producer(Vector sharedQueue, int size) {
		super();
		this.sharedQueue = sharedQueue;
		this.size = size;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<7;i++) {
			System.out.println("produced:"+i);
			try {
				produce(i);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void produce(int i) {
		while(sharedQueue.size()==size) {
			synchronized (sharedQueue) {
				System.out.println("queue is full"+Thread.currentThread().getName()+
				"is waiing,size"+sharedQueue.size());
			}
		}
		synchronized (sharedQueue) {
			sharedQueue.add(i);
			sharedQueue.notifyAll();
		}
	}
}

package lyc.thread.queueThread.other;

import java.util.concurrent.locks.ReentrantLock;

public class Test {

	public static void main(String[] args) throws Exception {
		ReentrantLock loc = new ReentrantLock();
		TaskDispatchorService mDispatchorService = new TaskDispatchorService();

		mDispatchorService.start();
		for(int i=0;i<5;i++) {
			mDispatchorService.recieveDate(i);
//			if(i>2) {
//				mDispatchorService.stop();
//			}
		}
		mDispatchorService.stop();
	}
}

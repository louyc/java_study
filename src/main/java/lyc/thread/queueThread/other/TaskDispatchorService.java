package lyc.thread.queueThread.other;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskDispatchorService {

	private BlockingQueue<Object> dataDispatchorQueue =  new ArrayBlockingQueue(1024);
	
	
	public void recieveDate(Object obj) {
		try {
			System.out.println("put::"+obj);
			dataDispatchorQueue.put(obj);
		} catch (InterruptedException e) {
		}
	}
	public void start() throws Exception {
		TaskDispatchorHandler tdh = new TaskDispatchorHandler("1111",dataDispatchorQueue);
		ThreadServiceProps.getThreadProps().addService(tdh);;
	}
	public void stop() throws Exception {
		System.out.println("stop");
		clear();
		ThreadServiceProps.getThreadProps().removeServiceByName("1111");
	}
	
	public void clear() {
		try{
		dataDispatchorQueue.clear();
		}catch(UnsupportedOperationException e){
		}
	}
}

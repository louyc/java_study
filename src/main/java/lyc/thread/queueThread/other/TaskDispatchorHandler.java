package lyc.thread.queueThread.other;

import java.util.concurrent.BlockingQueue;

public class TaskDispatchorHandler implements Runnable{

	private BlockingQueue<Object> queue;
	
	private String serviceName;

	private boolean threadRunning = false;

	public TaskDispatchorHandler(String serviceName,BlockingQueue<Object> queue) {
		super();
		this.serviceName = serviceName;
		this.queue = queue;
	}

	public void setThreadRunning(boolean threadRunning) {
		this.threadRunning = threadRunning;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void stop(boolean b) {
		this.threadRunning = b;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(threadRunning) {
			try {
				
				Object o= queue.take();
				System.out.println("take:::"+o);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
	}


}

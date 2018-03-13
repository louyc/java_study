package lyc.thread;

import java.net.Socket;

/**
 * 单线程
 * @author lyc
 *
 */
public class ThreadRunnableDemo implements Runnable{

	volatile boolean b = true;
	int i=0;
	private Socket socket;
	
	public ThreadRunnableDemo() {
		super();
	}
	public ThreadRunnableDemo(Socket socket) {
		super();
		this.socket = socket;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(b) {
			i++;
		}
	}
	/**
	 * 测试volatile 解决线程并发不安全问题
	 * @throws InterruptedException
	 */
	public static void TreadSafe() throws InterruptedException {
		ThreadRunnableDemo td = new ThreadRunnableDemo();
		Thread th = new Thread(td);
		th.start();
		Thread.sleep(10);
		td.b = false;
		System.out.println(":::"+td.i);
		Thread.sleep(1000);
		System.out.println(td.i);
		System.out.println("程序停止");
	}
	public static void main(String[] args) throws InterruptedException {
		
		
	}
	
	
	

}

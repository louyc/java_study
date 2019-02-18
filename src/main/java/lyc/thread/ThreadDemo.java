package lyc.thread;

public class ThreadDemo{


	static class ThreadDemo1 implements Runnable{
		public void run() {
			String name = Thread.currentThread().getName();
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name+" "+i);
			}
		}
	}
	static class ThreadDemo2 implements Runnable{
		public void run() {
			String name = Thread.currentThread().getName();
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name+" "+i);
			}
		}
	}
	static class ThreadDemo3 implements Runnable{
		public void run() {
			String name = Thread.currentThread().getName();
			for(int i=0;i<5;i++) {
				System.out.println(name+" "+i);
			}
		}
	}


	public static void main(String[] args) throws InterruptedException {
		System.out.println("开始");
		ThreadDemo1 td1 = new ThreadDemo1();
		ThreadDemo2 td2 = new ThreadDemo2();
		ThreadDemo3 td3 = new ThreadDemo3();
		Thread t1 = new Thread(td1, "线程1");
		Thread t2 = new Thread(td2, "线程2");
		Thread t3 = new Thread(td3, "线程3");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
System.out.println("end");		
		
	}
}

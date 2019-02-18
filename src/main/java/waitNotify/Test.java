package waitNotify;

import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		Vector queue = new Vector<>();
		int size=4;
		Thread pro= new Thread(new Producer(queue,size),"pro");
		Thread con = new Thread(new Consumer(queue, size), "con");
		pro.start();
		con.start();
	}
}

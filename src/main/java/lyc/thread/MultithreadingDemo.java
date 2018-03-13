package lyc.thread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 多线程
 * @author lyc
 *
 */
public class MultithreadingDemo {

	public static void main(String[] args) {
		Executor executor = Executors.newCachedThreadPool();
		
		 try {
	         ServerSocket serverSocket = new ServerSocket(4999);
	         while (true) {
	             Socket socket = serverSocket.accept();
	             executor.execute(new ThreadRunnableDemo(socket));
	         }
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	}
	
}

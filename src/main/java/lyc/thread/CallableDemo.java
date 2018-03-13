package lyc.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo implements Callable<Object>{

	private String taskNum;
	
	CallableDemo(String taskNum){
		this.taskNum = taskNum;
	}
	
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("任务开始");
		Date date1 = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		long time = date2.getTime() - date1.getTime();
		System.out.println("任务结束"+time);
		return taskNum+"返回结果";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
//		Executor excu = Executors.newFixedThreadPool(1);
//		Callable c = new CallableDemo("lll");
//		excu.execute(c);
		int taskSize = 2;
		//创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		//创建多个有返回值的任务
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {  
            Callable c = new CallableDemo(i + " ");  
            // 执行任务并获取Future对象  
            Future f = pool.submit(c);  
            list.add(f);  
        }
		//关闭线程池
		pool.shutdown();
		for(Future f :list) {
			System.out.println(">>"+f.get().toString());
		}
	}
	
}

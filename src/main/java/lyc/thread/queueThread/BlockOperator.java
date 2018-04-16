package lyc.thread.queueThread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 阻塞队列 + 线程 实现多线程并发
 * 
 * @author lyc
 *
 */
public class BlockOperator {

	private Object notEmpty = new Object();  
	private Queue<Object> linkedList = new LinkedList<Object>();  


	/** 
	 * 取物品 
	 *  
	 * @return 
	 * @throws InterruptedException 
	 */  
	public Object take() throws InterruptedException {  
		synchronized (notEmpty) {  
			String cureadname = Thread.currentThread().getName();  
			System.out.println("搬运工" + cureadname + "来到仓库");  
			sleep(1000l);  
			if (linkedList.size() == 0) {  
				// 假如仓库没东西了，那么就先不取物品，此时释放锁，被唤醒之前，需要先得到锁  
				System.out.println("搬运工" + cureadname + "发觉没有物品，只能等待生产");  
				notEmpty.wait();  
			}  
			Object obj = linkedList.poll();//返回并删除此元素  
			System.out.println("搬运工" + cureadname + "这时看到有了物品，搬出了:" + obj  
					+ "仓库还有物品数量:" + linkedList.size());  
			return obj;  

		}  
	}  

	// 生产物品  
	public void offer(Object object) throws InterruptedException {  
		synchronized (notEmpty) {  
			String cureadname = Thread.currentThread().getName();  
			System.out.println("生产工" + cureadname + "来到仓库准备放物品");  
			sleep(3000l);  
			if (linkedList.size() == 0) {  
				// 假如仓库没东西了，唤醒对象锁。分析：这个时候有可能没有等待锁，也可能有。  
				System.out.println("生产工" + cureadname+ "发现来到仓库的时候一件物品都没有，发觉搬运工在睡觉等他或者感觉搬运工在等他，于是喊醒了它");  
				notEmpty.notifyAll();   
				/* 
				 * 注 假如仓库有东西，那么不用唤醒搬运工，因为有物品的时候，搬运工不会等待。 
				 * 分析：有的人肯定会觉得，有没有这种可能：当linkedList.size=0的时候，notEmpty就wait了，然后在本同步块中， 
				 * 发现linkedList.size！=0，那么notEmpty就不会去唤醒了。其实这完全没有可能，因为size！=0只有在完成了 
				 * linkedList.add之后才有可能，而在add之前，必然会判断size=0的情况 
				 */  
			}  
			System.out.println("生产工" + cureadname + "把物品" + object  
					+ "放到了仓库");  
			linkedList.add(object);  

		}  
	}  

	private void sleep(Long time) {  
		try {  
			Thread.sleep(time);// 模拟时间消耗  
		} catch (InterruptedException e) {  
			e.printStackTrace();  
		}  
	}  

}

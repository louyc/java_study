package lyc.thread.queueThread;

public class CreateProduce implements Runnable{

	private BlockOperator bq;  
	public CreateProduce(BlockOperator bq){  
		this.bq=bq;  
	}  

	@Override  
	public void run() {  
		//生产n个产品  
		for(int i=0;i<5;i++){  
			Object obj="A"+i;  
			try {  
				bq.offer(obj);  
			} catch (InterruptedException e) {  
				e.printStackTrace();  
			}  
		}         
	}  
}

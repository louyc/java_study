package lyc.thread.queueThread;

public class TestMain {

	public static void main(String[] args) {  
		BlockOperator bq = new BlockOperator();  
		Thread createThread = new Thread(new CreateProduce(bq),"creater");  
		Thread getThread = new Thread(new GetProduce(bq),"getter");  
		createThread.start();  
		getThread.start();  


	}  
}

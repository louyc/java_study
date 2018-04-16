package lyc.thread.queueThread;

public class GetProduce implements Runnable{

	private BlockOperator bq;  
    public GetProduce(BlockOperator bq){  
        this.bq=bq;  
    }  
    @Override  
    public void run() {  
         try {  
             //搬运工是有多少搬多少  
             while(true){  
                 Object obj=bq.take();  
             }  
              
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    } 
}

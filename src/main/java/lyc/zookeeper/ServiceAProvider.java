package lyc.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.data.Stat;

public class ServiceAProvider {

	private String serviceName="service-A";  
    
    public void init(){  
        String severList="127.0.0.1:2181";    
        String rootPath="/servers";  
        ZkClient zk=new ZkClient(severList, 5000, 5000);  
        if(!zk.exists(rootPath)){  
            zk.createPersistent(rootPath);  
        }  
        if(!zk.exists(rootPath+"/"+serviceName)){  
            zk.createPersistent(rootPath+"/"+serviceName);  
        }  
          
        //获取本服务器IP  
        String ip="92.168.58.131";  
        Stat stat=new Stat();  
        zk.createPersistent(rootPath+"/"+serviceName+"/"+ip);  
        System.out.println("znode:"+rootPath+"/"+serviceName+"/"+ip+"创建完成");  
    }  
      
    //提供服务  
    public void provide(){  
          
    }  
      
    public static void main(String[]args) throws Exception {  
        ServiceAProvider service = new ServiceAProvider();  
        service.init();  
          
        Thread.sleep(1000*60*60*24);  
    }  
}

package lyc.zookeeper;

import org.I0Itec.zkclient.ZkClient;

public class ServiceBProvider {

	private String serviceName="service-B";  
    
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
        String ip="92.168.58.132";  
        zk.createPersistent(rootPath+"/"+serviceName+"/"+ip);  
        System.out.println("znode:"+rootPath+"/"+serviceName+"/"+ip+"创建完成");  
    }  
      
    //提供服务  
    public void provide(){  
          
    }  
      
    public static void main(String[]args) throws Exception {  
        ServiceBProvider service = new ServiceBProvider();  
        service.init();  
          
        Thread.sleep(1000*60*60*24);  
    }  
}

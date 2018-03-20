package lyc.designPattern.agent.dynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * 
 *  实现InvocationHandler接口，创建自己的调用处理器 。
	给Proxy类提供ClassLoader和代理接口类型数组创建动态代理类 。
	执行真实角色具体任务。
 * @author lyc
 *
 */
public class ProxySubject implements InvocationHandler {

	private RealSubject read;
	public ProxySubject(RealSubject read) {
		super();
		this.read = read;
	}
	@Override  
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  
		Object returnValue = method.invoke(read, args);  
        return returnValue;  
    } 
}

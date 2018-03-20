package lyc.designPattern.agent.dynamicAgent;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {

		/*代理的真实对象*/  
		RealSubject real = new RealSubject();  
		/*代理哪个对象就把真实对象传进去*/  
		ProxySubject proxySubject = new ProxySubject(real);  
		/* 
		 * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数 
		 * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象 
		 * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了 
		 * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上 
		 */  
		AbstractSubject a = (AbstractSubject) Proxy.newProxyInstance(real.getClass().getClassLoader(),   
				real.getClass().getInterfaces(), proxySubject);  
		a.sing();
		
		/** 
		 * InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发 
		 * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用. 
		 * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法 
		 */  
		ProxySubject handler = new ProxySubject(real);  

		ClassLoader loader = real.getClass().getClassLoader();  
		Class[] interfaces = real.getClass().getInterfaces();  
		/** 
		 * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例 
		 */  
		AbstractSubject subject = (AbstractSubject) Proxy.newProxyInstance(loader, interfaces, handler);  

		System.out.println("动态代理对象的类型："+subject.getClass().getName());  

	}
}

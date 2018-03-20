package lyc.designPattern.singleton;

public class SingletonDemo {

	/**
	 * 饿汉模式  线程安全的   内存占用
	 */
	private static final SingletonDemo singleton = new SingletonDemo();
	
	public static SingletonDemo getSingleton() {
		return singleton;
	}
	
	/**
	 * 懒汉模式   延迟加载    非线程安全
	 */
	private static SingletonDemo singletonLazy = null;
	
	public static SingletonDemo getSingletonLazy() {
		if(singletonLazy ==null) {
			return new SingletonDemo();
		}
		return singletonLazy;
	}
	
	/**
	 * 懒汉模式   双重校验 (加了volatile  可见性  有序性 第二次校验空 有可能出现指令重拍导致的问题)
	 */
	private static volatile SingletonDemo singletonVolLazy = null;
	
	public static SingletonDemo getSingletonLazyCheck() {
		if(singletonVolLazy==null) {
			synchronized (SingletonDemo.class) {
				if(singletonVolLazy == null) {
					return new SingletonDemo();
				}
			}
		}
		return singletonVolLazy;
	}
	
	
}

package lyc.thread.queueThread.other;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ThreadServiceProps {

	private final ConcurrentMap<String, TaskDispatchorHandler> serviceProps =new ConcurrentHashMap<String, TaskDispatchorHandler>();

	private final ConcurrentMap<String, Thread> threadProps = new ConcurrentHashMap<String, Thread>();

	private static ThreadServiceProps tsp = new ThreadServiceProps();
	public static ThreadServiceProps getThreadProps() {
		return tsp;
	}
	
	public void addService(TaskDispatchorHandler service) throws Exception {
		String name = service.getServiceName();
		if (name == null || "".equals(name)) {
			throw new IllegalArgumentException("Null Pointer of serviceName");
		}
		if (serviceProps.containsKey(name)) {
			throw new Exception("NMService Error，该线程已经存在 " + name);
		} else {
			synchronized (ThreadServiceProps.class) {
				clearInvalidService();
				if (serviceProps.containsKey(name)) {
					throw new Exception("NMService Error，该线程已经存在 " + name);
				} else {
					serviceProps.put(name, service);	//rem 2016-07-06
					service.setThreadRunning(true);
					Thread thread = new Thread(service);
					thread.setName(name);
					thread.start();
					while (thread.isAlive() == false) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					threadProps.put(name, thread);
				}
			}
		}
	}
	
	public void removeServiceByName(String serviceName) throws Exception {
		if (serviceName == null || "".equals(serviceName)) {
			throw new IllegalArgumentException("Null Pointer of serviceName");
		}
		if (serviceProps.containsKey(serviceName)) {
			synchronized (ThreadServiceProps.class) {
				if (serviceProps.containsKey(serviceName)) {
					serviceProps.get(serviceName).stop(false);;
					serviceProps.remove(serviceName);
				} else {
					throw new Exception("NMServicePool Error，该线程不存在 " + serviceName);
				}
			}
		} else {
			throw new Exception("NMServicePool Error，该线程不存在 " + serviceName);
		}
		if (threadProps.containsKey(serviceName)) {
			synchronized (ThreadServiceProps.class) {
				if (threadProps.containsKey(serviceName)) {
					Thread thread = threadProps.get(serviceName);
					if (thread == null) {
						return;
					}
					if (thread.isAlive()) {
						thread.interrupt();
					}
					threadProps.remove(serviceName);
				} else {
					throw new Exception("NMServicePool Error，该线程不存在 " + serviceName);
				}
			}
		}
	}
	/**
	 * 清理无效的线程服务
	 */
	private void clearInvalidService() {
		for (String name:threadProps.keySet()){
			Thread thread = threadProps.get(name);
			if (thread == null) continue;
			if (thread.isAlive() == false) {
				threadProps.remove(name);
				serviceProps.remove(name);
			}
		}
	}
	
}

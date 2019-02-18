package lyc.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor{

	private Object targetObject;

	public Object createProxyObject(Object obj) {
		this.targetObject = obj;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj.getClass());
		enhancer.setCallback(this);
		Object proxyObj = enhancer.create();
		// 返回代理对象
		return proxyObj;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		Object obj1 = null;
		// 过滤方法
		if ("addUser".equals(method.getName())) {
			// 检查权限
			checkPopedom();
		}
		obj1 = method.invoke(targetObject, args);
		return obj1;
	}

	private void checkPopedom() {
		System.out.println("======检查权限checkPopedom()======");
	}

}

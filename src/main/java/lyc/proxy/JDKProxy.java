package lyc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * @author Administrator
 *
 */
public class JDKProxy implements InvocationHandler{

	/**
	 * 需要代理的目标对象
	 */
	private Object taragetObject;
	
	/**
     * 将目标对象传入进行代理
     */
	public Object newProxy(Object taragetObject) {
		this.taragetObject = taragetObject;
		
		return Proxy.newProxyInstance(taragetObject.getClass().getClassLoader(), 
				taragetObject.getClass().getInterfaces(), this);
				
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 // 一般我们进行逻辑处理的函数比如这个地方是模拟检查权限
        checkPopedom();
        // 设置方法的返回值
        Object ret = null;
        // 调用invoke方法，ret存储该方法的返回值
        ret  = method.invoke(taragetObject, args);
//        return ret;
        return null;

	}

	/**
     * 模拟检查权限的例子
     */
    private void checkPopedom() {
        System.out.println("======检查权限checkPopedom()======");
    }
}

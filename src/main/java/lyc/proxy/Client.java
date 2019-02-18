package lyc.proxy;

/**
 * jdk动态代理
 * cglib动态代理
 * 
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {

		System.out.println("**********************JDKProxy**********************");
		JDKProxy jdkPrpxy = new JDKProxy();
		IUserManager userManagerJDK = (IUserManager) jdkPrpxy.newProxy(new UserManagerImpl());
		userManagerJDK.addUser("lanhuigu", "123456");

		System.out.println("**********************CGLibProxy**********************");
		CGLibProxy cgLibProxy = new CGLibProxy();
//		IUserManager userManager = (IUserManager) cgLibProxy.createProxyObject(new UserManagerImpl());
		CGLibManager userManager = (CGLibManager) cgLibProxy.createProxyObject(new CGLibManager());
		userManager.addUser("lanhuigu", "123456");
	}
}

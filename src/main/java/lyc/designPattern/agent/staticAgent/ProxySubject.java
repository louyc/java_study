package lyc.designPattern.agent.staticAgent;

/**
 * 静态代理
 * 
 * @author lyc
 *
 */
public class ProxySubject implements AbstractSubject{

	private RealSubject read;
	public ProxySubject(RealSubject read) {
		super();
		this.read = read;
	}
	@Override
	public void sing() {
		read.sing();
	}
}

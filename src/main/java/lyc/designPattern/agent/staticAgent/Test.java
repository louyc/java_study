package lyc.designPattern.agent.staticAgent;

public class Test {

	public static void main(String[] args) {
		RealSubject real = new RealSubject();
		ProxySubject ps = new ProxySubject(real);
		ps.sing();
	}
}

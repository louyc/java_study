package lyc.designPattern.decorator;

/**
 * 装饰者模式必然有一个公共的接口或抽象类，用来作为对象的传递。
 * 你需要根据接口实现基本的被装饰类，以及装饰类的公共接口，以后所有的装饰类都是继承自公共的装饰类接口，内部实现。
 * @author lyc
 *
 */
public abstract class Device implements AbstractComputer{

	public abstract String name();
	public abstract double price();
}

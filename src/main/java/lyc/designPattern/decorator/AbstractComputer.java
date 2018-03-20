package lyc.designPattern.decorator;

/**
 * 装饰器模式
 * 装饰器设计模式顾名思义就是装饰某个对象，让一个功能单一的对象拥有一些其他的功能，这些功能的添加是动态的
 * 
 * @author lyc
 *
 */
public interface AbstractComputer {

	public abstract String name();
	public abstract double price();
}

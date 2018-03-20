package lyc.designPattern.adapter;

/**
 * 适配器模式
 * 适配器模式是将一个类的接口转换成用户希望的另一种接口
 * 
 * 类适配器    适配器继承自已实现的类（一般多重继承）
 * @author lyc
 *
 */
public interface Target {

	public abstract void function1();  
	  
    public abstract void function2();
}

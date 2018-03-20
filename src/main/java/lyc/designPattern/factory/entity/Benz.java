package lyc.designPattern.factory.entity;

/**
 * 
 * 具体产品 
 * @author lyc
 *
 */

public class Benz implements Car{

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("我要开奔驰");
	}
}

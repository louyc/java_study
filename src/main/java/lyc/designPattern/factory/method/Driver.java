package lyc.designPattern.factory.method;

import lyc.designPattern.factory.entity.Benz;
import lyc.designPattern.factory.entity.Bmw;
import lyc.designPattern.factory.entity.Car;

/**
 * 工厂方法
 * 具体工厂  抽象工厂
 * @author lyc
 *
 */
public interface Driver {

	public Car driverCar();
}

class BenzDriver implements Driver{ 
	public Car driverCar(){ 
		return new Benz(); 
	} 
} 
class BmwDriver implements Driver{ 
	public Car driverCar() { 
		return new Bmw(); 
	} 
}

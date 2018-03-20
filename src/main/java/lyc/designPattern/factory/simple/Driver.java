package lyc.designPattern.factory.simple;

import lyc.designPattern.factory.entity.Benz;
import lyc.designPattern.factory.entity.Bmw;
import lyc.designPattern.factory.entity.Car;

/**
 *具体工厂
 *
 *工厂类核心 
 * @author lyc
 */

public class Driver {

	public static Car driver(String s) {
		if(s.equalsIgnoreCase("Benz")) {
			return new Benz();
		}
		if(s.equalsIgnoreCase("Bmw")) {
			return new Bmw();
		}
		return null;
	}

	public static void main(String[] args) {
		Car car = Driver.driver("benz");
		car.drive();
	}
}

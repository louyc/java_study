package lyc.designPattern.factory.method;

import lyc.designPattern.factory.entity.Car;

public class Magnate {

	public static void main(String[] args) {
		
		Driver driver = new BenzDriver();
		Car car = driver.driverCar();
		car.drive();
	}
}

package lyc.designPattern.decorator;

public class Computer implements AbstractComputer{

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "笔记本";
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 5000;
	}

}

package lyc.designPattern.decorator;

/**
 * 硬盘类
 * @author lyc
 *
 */
public class HardDisk extends Device{

	public AbstractComputer computer;

	public HardDisk(AbstractComputer computer) {
		super();
		this.computer = computer;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return computer.name()+"加固态";
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return computer.price()+500;
	}
}

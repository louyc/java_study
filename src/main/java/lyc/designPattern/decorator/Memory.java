package lyc.designPattern.decorator;

/**
 * 内存
 * @author lyc
 *
 */
public class Memory extends Device{

	public AbstractComputer computer;
	
	public Memory(AbstractComputer computer) {
		super();
		this.computer = computer;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return computer.name()+"加内存";
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return computer.price()+500;
	}

}

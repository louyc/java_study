package lyc.designPattern.decorator;

public class Test {

	public static void main(String[] args) {
		Computer computer = new Computer();
		  
        HardDisk h = new HardDisk(computer);
        System.out.println(h.name());
        System.out.println("价格:"+h.price());
  
        Memory m = new Memory(computer);
        System.out.println(m.name());
        System.out.println("价格:"+m.price());
  
        HardDisk h1=new HardDisk(m);
        System.out.println(h1.name());
        System.out.println("价格:"+h1.price());
	}
}

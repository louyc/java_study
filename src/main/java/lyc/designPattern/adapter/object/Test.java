package lyc.designPattern.adapter.object;

public class Test {

	public static void main(String[] args) {  
		Adaptee a = new Adaptee();  
		Adapter adapter = new Adapter(a);  
		adapter.function1();  
		adapter.function2();  
	}  
}

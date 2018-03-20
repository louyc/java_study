package lyc.designPattern.adapter.classAdapter;

import lyc.designPattern.adapter.Target;

public class Test {

	public static void main(String[] args) {  
        Target target = new Adapter();  
        target.function1();  
        target.function2();  
    }  
}

package lyc.designPattern.adapter.classAdapter;

import lyc.designPattern.adapter.Target;

public class Adapter extends Adaptee implements Target{

	@Override  
    public void function2() {  
        System.out.println("Adapter的function2方法");  
    }  
}

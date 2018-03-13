package lyc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JOptionPane;

/** 
 * 通过用户输入类的全路径，来获取该类的成员方法和属性 
 * Declared获取全部不管是私有和公有 
 * 1.获取访问类的Class对象 
 * 2.调用Class对象的方法返回访问类的方法和属性信息 
 **/  
public class ReflectDemo {

	public ReflectDemo() {
		
	}
	public void swingReflect() {
		System.out.println("start");
		String classpath = JOptionPane.showInputDialog(null, "输入类的全路径");
		Class cla;
		try {
			cla = Class.forName(classpath);
			reflect(cla);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void classReflect(Person p) {
		System.out.println("start");
//		Class cla = p.getClass();
		Class cla = Person.class;
		reflect(cla);

	}
	public void reflect(Class cla) {
		//利用Class对象的cla的自审,返回方法对象集合  
		Method [] method = cla.getDeclaredMethods();
		for(Method m: method) {
			System.out.println(m.toString());
		}
		//获取属性利用Class对象的cla的自审,返回成员属性对象集合 
		Field [] field = cla.getDeclaredFields();
		for(Field f:field) {
			System.out.println(f.toString());
		}
		//获取属性利用Class对象的cla的自审,返回构造方法集合  
		Constructor [] constructor = cla.getDeclaredConstructors();
		for(Constructor c:constructor) {
			System.out.println(c.toString());
		}
	}
	public static void main(String[] args) {
		ReflectDemo rd = new ReflectDemo();
//		rd.swingReflect();
		Person p = new Person();
		rd.classReflect(p);
	}
}

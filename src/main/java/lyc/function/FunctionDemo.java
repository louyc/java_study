package lyc.function;

import java.util.ArrayList;
import java.util.List;

import lyc.function.entity.Person;

public class FunctionDemo {

	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<Person>();
		Person p = new Person("li","nan",12);
		Person p1 = new Person("wang","nan",14);
		list.add(p1);
		list.add(p);
		PersonService ps = new PersonService(list);
		List<Person> li = ps.findByAge(12);
		System.out.println(li.size());
		System.out.println(li.get(0).getName());
	}
}

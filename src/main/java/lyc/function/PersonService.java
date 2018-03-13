package lyc.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lyc.function.entity.Person;

public class PersonService {

	 //假设这个list是通过已有接口返回的所有Person集合
    private List<Person> list = new ArrayList<Person>();
    
    public PersonService(List<Person> list) {
		super();
		this.list = list;
	}

	public List<Person> findByName(String name) {
        return find(p -> name.equals(p.getName()));
    }

    public List<Person> findByGender(String gender) {
       return find(p -> gender.equals(p.getGender()));
    }

    public List<Person> findByAge(int age){
    	return find(p->age == p.getAge());
    }
    
    public List<Person> find(Predicate<Person> predicate){
        return list.stream().filter(p -> predicate.test(p)).collect(Collectors.toList());
    }
}


package lyc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {

	public static void main(String[] args) {
		Map map = new HashMap<>();
		map.put(null, null);
		System.out.println(map.entrySet());
		System.out.println(2&4);
		System.out.println(2&3);
		String s1 ="abc";
		String s3 ="abc";
		String s2 = new String("abc");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s2));
		int a= 1;
		Integer b = 1;
		System.out.println(a==b);
		bianliArrayList();
	}
	private static void bianliArrayList() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		for(String i: list) {
			if(i=="2") {
				list.remove(i);
			}
			System.out.println(i+"aaa");
		}
		for(String i: list) {
			System.out.println(i);
		}
	}
}


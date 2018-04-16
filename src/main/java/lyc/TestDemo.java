package lyc;

import java.util.HashMap;
import java.util.Map;

public class TestDemo {

	public static void main(String[] args) {
		Map map = new HashMap<>();
		map.put(null, null);
		System.out.println(map.entrySet());
		System.out.println(2&4);
		System.out.println(2&3);
		String s1 ="abc";
		String s2 = new String("abc");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}

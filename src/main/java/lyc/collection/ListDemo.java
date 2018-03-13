package lyc.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class ListDemo {

	public static void main(String[] args) {
		remove();
	}
	public static void list() {
		List<String> lists = new ArrayList<String>();
		lists.add("1");
		lists.add("2");
		ListIterator<String> listi = lists.listIterator();
		while(listi.hasNext()) {
			String s = listi.next();
			System.out.println(s);
		}
	}
	public static void linkedList() {
		List<String> lists = new LinkedList<String>();
		lists.add("1");
		lists.add("2");
		lists.remove(1);
		ListIterator<String> listi = lists.listIterator();
		while(listi.hasNext()) {
			String s = listi.next();
			System.out.println("LinkedList"+s);
		}
	}
	public static void hashSet() {
		Set set = new HashSet();
		Set set1 = new LinkedHashSet();
		Set set2 = new TreeSet();
	}
	
	public static void remove() {
		List<String> lists = new ArrayList<String>();
		lists.add("1");
		lists.add("2");
		lists.add("2");
		lists.add("2");
		/*for(String s: lists) {
			if(s.equals("2")) {
				lists.remove(s);
			}
		}*/
		Iterator ite = lists.iterator();
		while(ite.hasNext()) {
			String s = (String)ite.next();
			if(s.equals("2")) {
				ite.remove();
			}
		}
		/*for(int i=0;i<lists.size();i++) {
			String s = lists.get(i);
			if(s.equals("2")) {
				lists.remove(s);
			}
		}*/
		System.out.println(lists.size()+lists.get(0));
	}

}

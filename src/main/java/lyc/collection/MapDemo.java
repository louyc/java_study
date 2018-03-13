package lyc.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Map 集合
 * @author lyc
 *
 */
public class MapDemo {

	public static void main(String[] args) {
//		keySet();
//		valueCollection();
//		entry();
		int[] array = {1,3,45,2};
		mapPaiXu(array);
	}
	public static void keySet() {
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map1 = new LinkedHashMap<String,Object>();
		Map<String,Object> map2 = new TreeMap<String,Object>();
		map.put("1", "a");
		Set<String> setKey = map.keySet();
		Iterator iter = setKey.iterator();
		while(iter.hasNext()) {
			String key = (String)iter.next();
			System.out.print(key);
			System.out.print(map.get(key));
		}
	}
	public static void valueCollection() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("1", "a");
		Collection<Object> cvalues = map.values();
		System.out.println(cvalues);
	}
	public static void entry() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("1", "a");
		Set<Entry<String, Object>> setM = map.entrySet();
		Iterator ite = setM.iterator();
		while(ite.hasNext()) {
			Entry entry = (Entry) ite.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
	public static void hashTable() {
		Map<Object,Object> map = new Hashtable<Object, Object>();
		map.put("1","1");
	}
	public static void concurrentHashMap() {
		Map<Object,Object> map = new ConcurrentHashMap<Object,Object>();
		map.put("1", "1");
	}
	/**
	 * 倒叙排序
	 * @param array
	 */
	public static void mapPaiXu(int[] array) {
		
		for(int min=0,max=array.length-1;min<max;min++,max--) {
//			if(array[min]<array[max]) {
				int temp = array[min];
				array[min] = array[max];
				array[max] = temp;
//			}
		}
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	
}

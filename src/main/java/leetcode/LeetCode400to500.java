package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode400to500 {

	public static void main(String[] args) {
//		System.out.println("abac".substring(2,4));
		System.out.println(question459("aaa"));
	}
	public static boolean question459(String s) {
		boolean b = false;
		char[] cs = s.toCharArray();
		int leng = cs.length;
		Set<Integer> set = new HashSet<Integer>();
		Set<String> setResult = new HashSet<String>();
		if(leng<=1) {
			return b;
		}else if(leng ==2) {
			if(cs[0]==cs[1]) {
				return true;
			}else {
				return b;
			}
		}else if(leng ==3) {
			if(cs[0]==cs[1] && cs[1]== cs[2]) {
				return true;
			}else {
				return b;
			}
		}
		
		for(int i = 2; i <= Math.sqrt(leng); i++){ 
			set.add(leng);
			if(leng % i == 0){  
				set.add(i);
				set.add(leng/i);
			}  
		}
		for(Integer i: set) {
			setResult.clear();
			for(int j=0;j<leng;) {
				setResult.add(s.substring(j, j+(leng/i)));
				j = j+(leng/i);
			}
			if(setResult.size()==1) {
				b =true;
				return b;
			}else {
				b = false;
			}
		}
		return b;
	}
	
	
}

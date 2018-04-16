package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode100to200 {

	public static void main(String[] args) {
		List<Integer> returnArray = question119(0);
		for(int i:returnArray) {
			System.out.print(i+" ");
		}
	}
	public static List<Integer> question119(int num) {
		List<Integer> list = new ArrayList<Integer>();
		if(num==0) {
			list.add(1);
		}else if(num==1) {
			list.add(1);
			list.add(1);
		}else if(num==2){
			list.add(1);
			list.add(2);
			list.add(1);
		}else {
			list.add(1);
			list.add(2);
			list.add(1);
			list = diedai(list,num);
		}
		return list;
	}
	public static List<Integer> diedai(List<Integer> begin,int k) {
		List<Integer> returnArray = new ArrayList<Integer>();
		returnArray.add(1);
		for(int i=1;i<begin.size();i++) {
			returnArray.add(begin.get(i-1)+begin.get(i)); 
		}
		returnArray.add(1);
		if(returnArray.size()!=k+1) {
			returnArray = diedai(returnArray,k);
		}
		return returnArray;
	}
}

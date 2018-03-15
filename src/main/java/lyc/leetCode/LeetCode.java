package lyc.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		nums = first(nums, target);
		System.out.println(nums[0]+" "+nums[1]);
	}
	public static int[] first(int[] nums, int target) {
		int[] result= new int[2];
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode root = new ListNode(0);
		ListNode r = root;
		int carry = 0;
		while(l1!=null && l2!=null) {
			int v1 = l1.val;
			int v2 = l2.val;
			int sum1 = v1+v2;
			int node = (sum1+carry)%10;
			root.val = node;
			carry = (sum1+carry)/10;
			l1 = l1.next;
			l2 = l2.next;
			root.next = root;
			r = root.next;
		}
		if(l1==null && l2 !=null) {
			root.next = l2;
		}
		if(l1!=null && l2 ==null) {
			root.next = l1;
		}
		if(carry >0) {
			
		}
		return null;
	}
}

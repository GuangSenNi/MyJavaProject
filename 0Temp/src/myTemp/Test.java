package myTemp;

import java.util.HashMap;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	static HashMap<Character,Character> map=new HashMap<Character,Character>();
	public static void init() {
		map.put('(',')');
		map.put('[', ']');
		map.put('{', '}');
	}
	public static boolean help(String str) {
		char[] arr=str.toCharArray();
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])||map.containsValue(arr[i])) {
				if(!stack.isEmpty()) {
					char c1=stack.peek();
					if(map.get(c1)==arr[i]) {
						stack.pop();
						continue;
					}
				}
				stack.push(arr[i]);
			}else {
				return false;
			}
			
		}
		if(stack.empty()) {
			return true;
		}else {
			return false;
		}
	}
	class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val=val;
		}
	}
	
	

}

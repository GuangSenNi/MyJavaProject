package test;

import java.util.LinkedList;
import java.util.List;

public class NaryTree {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
	}

	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	List<Integer> out=new LinkedList<Integer>();
	public List<Integer> preorder(Node root) {
		if(root==null)return out;
        out.add(root.val);
        for(int i=0;i<root.children.size();i++) {
        	Node n=root.children.get(i);
        	preorder(n);
        }
        return out;
    }
}

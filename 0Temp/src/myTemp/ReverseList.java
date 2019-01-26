package myTemp;

import java.util.ArrayList;

/*
题目要求：链表翻转。给出一个链表和一个数k，比如链表1→2→3→4→5→6，
k=2，则翻转后2→1→4→3→6→5，若k=3,翻转后3→2→1→6→5→4，
若k=4，翻转后4→3→2→1→5→6，
*/
class Node{
	Node next;
	int val;
	public Node(int val) {
		this.val=val;
	}
}
public class ReverseList {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Node node=new Node(-1);
		Node p1=node;
		for(int i=0;i<5;i++) {
			Node node1=new Node(i);
			p1.next=node1;
			p1=p1.next;
		}

		
		p1=ReverseK(node,4);
		while(p1!=null) {
			System.out.println(p1.val);
			p1=p1.next;
		}
		
	}
//指定k反转
	public static Node ReverseK(Node n,int k) {
		ArrayList<Node> arr=new ArrayList<>();
		Node p=n;
		int t=1;
		int c=0;
		while(p!=null) {
			if(t==1) {
				arr.add(p);
			}
			if(t==k) {
				Node temp=p;
				p=p.next;
				t=1;
				temp.next=null;
				Node rnode=Reverse(arr.get(c));
				arr.set(c, rnode);
				c++;
				continue;
			}
			p=p.next;
			t++;
		}
		for(int i=0;i<arr.size()-1;i++) {
			Node l=arr.get(i);
			while(l.next!=null) {
				l=l.next;
			}
			l.next=arr.get(i+1);
		}
		return arr.get(0);
	}
	//反转链表
	public static Node Reverse(Node n) {
		Node p=n;
		Node last=null;		
		while(p!=null) {
			Node temp=last;
			last=p;
			p=p.next;
			last.next=temp;
		}
		return last;
	}
	
}

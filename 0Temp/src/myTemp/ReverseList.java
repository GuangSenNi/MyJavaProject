package myTemp;

import java.util.ArrayList;

/*
��ĿҪ������ת������һ�������һ����k����������1��2��3��4��5��6��
k=2����ת��2��1��4��3��6��5����k=3,��ת��3��2��1��6��5��4��
��k=4����ת��4��3��2��1��5��6��
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
		// TODO �Զ����ɵķ������
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
//ָ��k��ת
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
	//��ת����
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

package linkList;

public class Linklist<E> implements Link<E>{

	private Node<E> head;
	private Node<E> last;
	private int size=0;
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Linklist<String> l=new Linklist<String>();
		l.add("a");
		l.add("aa");
		l.add("c");
		l.add("b");
		l.set(1, "hhh");
		l.remove(2);
		System.out.println(l.size);
		for(int i=0;i<l.size;i++) {
			System.out.println(l.get(i).e);
		}
	}

	@Override
	public void add(E e) {
		// TODO 自动生成的方法存根
		if(size==0) {
			head=new Node<E>();
			last=head;
		}
		Node<E> n=new Node<E>();
		n.e=(E)e;
		last.next=n;
		last=n;
		size++;
	}

	@Override
	public Node<E> get(int index) {
		// TODO 自动生成的方法存根
		if(index>size-1)return null;
		Node<E> n=head.next;
		int i=0;
		while(n!=null&&i<index) {
			n=n.next;
			i++;
		}
		return n;
	}

	@Override
	public Node<E> remove(int index) {
		// TODO 自动生成的方法存根
		if(index>size)return null;
		Node<E> n=head,p;
		int i=0;
		while(n!=null&&i<index) {
			n=n.next;
			i++;
		}
		p=n.next;
		if(p.next==null) {
			n.next=null;
			last=n;
			size--;
			return p;
		}
		n.next=n.next.next;
		size--;
		return p;
	}

	public boolean set(int index, E e) {
		// TODO 自动生成的方法存根
		if(index>size+1)return false;
		Node<E> n=head,p;
		int i=0;
		while(n!=null&&i<index) {
			n=n.next;
			i++;
		}
		Node<E> m=new Node<E>();
		m.e=e;
		p=n.next;
		n.next=m;
		m.next=p.next;
		return true;
	}
	

}

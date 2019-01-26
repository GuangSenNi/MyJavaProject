package linkList;

public interface Link <E>{

	public void add(E e);
	public Node<E> get(int index);
	public Node<E> remove(int index);
	public boolean set(int index,E e);
}

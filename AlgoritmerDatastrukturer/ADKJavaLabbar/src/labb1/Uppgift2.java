package labb1;

import java.util.*;

public class Uppgift2<E> implements Iterable<E>, Collection<E>, List{
	
	private class Node<E> {
		
		private E data;
		private Node<E> next;
		
		public Node(E inData, Node<E> inNext) {
			this.data = inData;
			this.next = inNext;
			
		}
		
	}
	private class NodeIterator implements Iterator<E>{
		
		private Node<E> point;
		
		public NodeIterator(Node<E> n) {
			point = n;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return this.point.next != null;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			Node<E> current = this.point;
			this.point = this.point.next;			
			return current.data;
		}
		
	}
	
	private Node<E> head;
	private int size;
	
	public Uppgift2() {
		this.head = null;
		this.size = 0;
		
	}
	
	
	
	@Override
	public boolean add(E e) {
		if (size == 0) {
			this.head = new Node<E>(e, null);
			size++;
			return true;
		}
		else {
			Node<E> current = head;
			boolean hasnext = current.next != null;
			while(hasnext) {
				current = current.next;				
			}
			current.next = new Node<E>(e, null);
			return true;
		}
		
	}
	
	public boolean add(int index, E e) {
		if (index <0 || index >= this.size) throw new IndexOutOfBoundsException();
		
		if (this.size == 0) {
			this.head = new Node<E>(e, null);
			this.size++;
			return true;
		}
		else {
			Node<E> current = head;
			boolean hasnext = current.next != null;
			int iterations = 0;
			while(hasnext && iterations < index) {
				current = current.next;
				iterations++;
			}
			current.next = new Node<E>(e, current.next);
			
			return true;
		}
		
		
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		Iterator<E> iter = c.iterator();
		while (iter.hasNext()) {
			this.add(iter.next());
		}
		return true;
	}

	@Override
	public void clear() {
		this.head = null;
		size = 0;
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		Iterator<E> iter = this.iterator();
		while (iter.hasNext()) {
			if (iter.next() == o) return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		Iterator<?> iter = c.iterator();
		while(iter.hasNext()) {
			if(!this.contains(iter.next())) return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		Iterator<E> iter = this.iterator();
		Node<E> current = this.head;
		while(iter.hasNext()) {
			if(current.next == o) {
				current.next = current.next.next;
				return true;
				
			}
			current = head.next;
			iter.next();
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		Iterator<?> iter = c.iterator();
		while(iter.hasNext()) {
			remove(iter.next());
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		Iterator<?> iter = c.iterator();
		while(iter.hasNext()) {
			Object current = iter.next();
			if(!this.contains(current)) {
				this.remove(current);
			}
		}
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new NodeIterator(this.head);
	}



	@Override
	public Object get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ListIterator listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Object remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Object set(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}

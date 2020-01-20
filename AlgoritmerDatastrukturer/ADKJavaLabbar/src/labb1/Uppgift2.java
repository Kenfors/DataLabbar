package labb1;

import java.util.*;

public class Uppgift2<E> implements Iterable<E>, Collection<E>{
	
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
		
		@Override
		public Object next() {
			Node<E> current = this.point;
			this.point = this.point.next;			
			return current;
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
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
	
	
	
	

}

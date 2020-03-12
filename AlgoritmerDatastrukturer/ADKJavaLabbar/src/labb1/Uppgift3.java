package labb1;

import java.util.Iterator;


public class Uppgift3<E> implements Iterable<E>{

	private Node<E> head;
	private int size;
	
	public Uppgift3() {
		head = null;
		size = 0;
	}
	
	
	private static class Node<E> {
		
		private E data;
		private Node<E> next;
		
		
		public Node(E inData) {
			this.data = inData;
			this.next = null;
		}
		
		public Node(Node<E> inNext, E inData) {
			this.data = inData;
			this.next = inNext;
		}
	}
	
	private class NodeIterator implements Iterator<E>{
		
		private Node<E> node;
		private Node<E> before;
		
		public NodeIterator() {
			this.node = head;
			this.before = null;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return this.node != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E data = this.node.data;			
			this.before = this.node;
			this.node = this.node.next;
			return data;
		}
		
		@Override
		public void remove() {
			if(before == null) {
				head = head.next;
			}
			if(node != null)
				node = node.next;
			before.next = node;

		}
		
	}
	
	
	
	public boolean add(E element) {
		if(size == 0) {
			head = new Node<E>(element);
			size++;
			return true;
		}
		
		Node<E> current = head;		
		while(current.next != null) current = current.next;
		current.next = new Node<E>(element);
		this.size++;
		return true;
	}
	
	public boolean add(int index, E element) {
		if(index > this.size || index < 0) throw new IndexOutOfBoundsException("" + index);
		Node<E> current = head;
		if(index == 0) {
			this.head = new Node<E>(head, element);
			this.size++;
			return true;
		}
		
		while(--index > 0) current = current.next;
		current.next = new Node<E>(current.next,element);
		this.size++;
		return true;
	}
	
	public E get(int index) {
		if(index > this.size-1 || index < 0) throw new IndexOutOfBoundsException("" + index);
		Node<E> current = head;
		while(index-- > 0) current = current.next;
		return current.data;
	}
	
	public int size() {
		return this.size;
	}
	
	public E remove(int index) {
		if(index > this.size-1 || index < 0) throw new IndexOutOfBoundsException("" + index);
		E removed = null;
		if(index == 0) {
			size--;
			removed = head.data;
			this.head = head.next;
			return removed;
		}
		
		Iterator<E> iter = iterator();
		System.out.println(index);
		while(index-- >= 0) removed = iter.next();
		iter.remove();
		size--;
		return removed;
	}
	
	
	public String toString() {
		if (size == 0) return "[]";
		String rturn = "[";
		Node<E> current = head;
		while(current != null) {
			rturn += "" + current.data + ", ";
			current = current.next;
		}
		rturn = rturn.substring(0, rturn.length() -2);
		return rturn + "]";
	}
	
	public Iterator<E> iterator(){
		return new NodeIterator();
	}
	
}





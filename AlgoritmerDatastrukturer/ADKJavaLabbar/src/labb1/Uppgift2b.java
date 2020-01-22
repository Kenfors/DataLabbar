package labb1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Uppgift2b<E> implements Iterable<E>{

	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public Uppgift2b() {
		head = null;
		tail = head;
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
		
		private Node<E> current;
		
		
		public NodeIterator(Node<E> head) {
			this.current = head;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(this.current == null) throw new NoSuchElementException();
			E retData = this.current.data;
			this.current = this.current.next;
			return retData;
		}
	}
	
	
	
	public boolean add(E element) {
		if(size == 0) {
			head = new Node<E>(element);
			tail = head;
			size++;
			return true;
		}
		
		tail.next = new Node<E>(element);
		tail = tail.next;
		size++;
		//Node<E> current = head;		
		//while(current.next != null) current = current.next;
		//current.next = new Node<E>(element);
		//this.size++;
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
		else if(index == size()) {
			tail.next = new Node<E>(element);
			tail = tail.next;
			size++;
			return true;
		}
		
		while(--index > 0) current = current.next;
		current.next = new Node<E>(current.next,element);
		this.size++;
		return true;
	}
	
	public E get(int index) {
		if(index > this.size-1 || index < 0) throw new IndexOutOfBoundsException("" + index);
		if(index == size-1) return tail.data; // O(1)
		Node<E> current = head;
		while(index-- > 0) current = current.next;
		return current.data;
	}
	
	public int size() {
		return this.size;
	}
	
	public E remove(int index) {
		if(index > this.size-1 || index < 0) throw new IndexOutOfBoundsException("" + index);
		Node<E> current = head;
		E removed;
		if(index == 0) {
			removed = head.data;
			this.head = head.next;
			this.size--;
			return removed;
		}
		
		while(--index > 0) current = current.next;
		removed = current.next.data;
		if(current.next == tail) {
			tail = current;
			current.next = null;
			this.size--;
			return removed;
		}
		current.next = current.next.next;
		this.size--;
		return removed;
	}
	
	public String toString() {
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
		return new NodeIterator(this.head);
	}
	
}





package labb1;

import java.util.*;

public class Uppgift2<E> implements Iterable<E>{
	
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public Uppgift2() {
		head = null;
		tail = head;
		size = 0;
	}
	
	
	private class Node<E> {
		
		private E data;
		private Node<E> next;
		
		public Node(E inData, Node<E> inNext) {
			this.data = inData;
			this.next = inNext;

		}
		
	}
	
	public void add(E data) {
		if(this.head == null || size == 0) {
			this.addFirst(data);
		}
		else {
			addAfter(tail, data);
			tail = tail.next;
		}
		this.size++;
		
	}
	
	public void add(int index, E data) {
		if(index > this.size || index < 0) throw new IndexOutOfBoundsException(Integer.toString(index));
		if(index == 0) {
			this.addFirst(data);			
		}
		else if(index == this.size-1) {
			addAfter(tail, data);
			tail = tail.next;
		}
		else {
			addAfter(getNode(index-1), data);
		}
		this.size++;
		
	}
	
	private void addFirst(E data) {
		if(this.head == null) {
			this.head = new Node<E>(data, null);
			this.tail = head;
		}
		else {
			Node<E> rest = this.head;
			this.head = new Node<E>(data, null);
			this.head.next = rest;
		}
		

	}
	
	private Node<E> getNode(int index){
		Node<E> n = this.head;
		while(index-- > 0) {
			n = n.next;
		}
		return n;
	}
	
	private void addAfter(Node<E> node, E data) {
		node.next = new Node<E>(data, node.next);
	}
	
	public E get(int index) {
		if(index < 0 || index > this.size -1) throw new IndexOutOfBoundsException(Integer.toString(index));
		Node<E> n = this.getNode(index);
		return n.data;
	}
	
	public E remove(int index) {
		if(index < 0 || index > this.size -1) throw new IndexOutOfBoundsException(Integer.toString(index));
		if(index == 0) {
			E old = this.head.data;
			this.head = this.head.next;
			this.size--;
			return old;
		}
		
		Node<E> n = this.getNode(index-1);
		E data = n.next.data;
		n.next = (n.next != null) ? n.next.next : null;
		if(index == this.size-1)
			this.tail = n;
		this.size--;
		return data;

	}
	
	public int size() {return this.size;}
	
	public String toString() {
		String str = "[";
		Node<E> n = this.head;
		while(n != null) {
			str += "" + n.data + ",";
			n = n.next;
		}
		str += "]";
		return str;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new NodeIterator(this.head);
	}
	
	
	
	
	private class NodeIterator implements Iterator<E>{
		
		private Node<E> node;
		
		public NodeIterator(Node<E> in) {
			this.node = in;
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
			this.node = this.node.next;
			return data;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}

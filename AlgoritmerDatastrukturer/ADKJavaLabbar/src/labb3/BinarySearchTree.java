package labb3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
	
	Node<E> root;
	private E deletedData;
	
	public BinarySearchTree() {
		this.root = null;
		this.deletedData = null;
	}
	
	
	private Node<E> delete(E target, Node<E> node){
		if(node == null) {
			deletedData = null;
			return null;
		} else {
			int diff = target.compareTo(node.data);
			if(diff < 0) { // Left..
				node.left = delete(target, node.left);
				return node;				
			} else if(diff > 0) { // Right
				node.right = delete(target, node.right);
				return node;
			}
			else { // This node..
				this.deletedData = node.data;
				if(node.left == null)
					return node.right;
				else if (node.right == null)
					return node.left;
				else {
					Node<E> parentToMove = node, nodeToMove = node.right;
					if(nodeToMove.left == null) {
						nodeToMove.left = node.left;
						return nodeToMove;
					}
					
					while(nodeToMove.left!=null) {
						parentToMove = nodeToMove;
						nodeToMove = nodeToMove.left;
					}
					parentToMove.left = nodeToMove.right;
					node.data = nodeToMove.data;
					return node;
					
				}
				
				
			}
			
		}
		
		
	}
	
	public E delete(E target) {
		root = delete(target, root);
		return deletedData;
	}
	
	public E search(E target) {
		
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node<E> current = queue.poll();
			if(target.compareTo(current.data) == 0)
				return current.data;
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);
			
		}
		
		return null;
	}
	
	public E maxRec() {
		return max(root.data, root);
	}
	
	private E max(E max, Node<E> node) {
		if(node == null) return null;
		
		if(max.compareTo(node.data) < 0)
			max = node.data;
		E left = max(max, node.left);
		if(left != null && max.compareTo(left) < 0)
			max = left;
		E right = max(max, node.right);
		if(right != null && max.compareTo(right) < 0)
			max = right;
		return max;
		
		
	}
	
	public E maxIte() {
		
		if (root==null) return null;
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		E target = root.data;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node<E> current = queue.poll();
			if(target.compareTo(current.data) < 0)
				target = current.data;
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);
			
		}
		
		return target;
	}
	
	private E find(E target, Node<E> node) {
		if(node==null) return null;
		int diff = target.compareTo(node.data);
		if(diff == 0) return node.data;
		if(diff < 0) return find(target, node.left);
		return find(target, node.right);		
	}
	
	public E find(E target) {
		return find(target, root);
	}
	
	public boolean add(E data) {
		if(root==null) {
			this.root = new Node<E>(data);
			return true;
		}
		return add(data, root);
	}
	
	private boolean add(E data, Node<E> node) {
		int diff = data.compareTo(node.data);
		if(diff == 0) {
			return false;
		} 
		else if(diff < 0) { //Go Left
			if(node.left == null) {
				node.left = new Node<E>(data);
				return true;
			} else {
				return this.add(data, node.left);
			}	
		}
		else {
			if(node.right==null) {
				node.right = new Node<E>(data);
				return true;
			} else {
				return this.add(data, node.right);
			}
		}
	}
	
	/* 1. Left
	 * 2. This
	 * 3. Right
	 * */
	private void inOrder(Node<E> node, StringBuilder sb) {
		if(node != null) {
			this.inOrder(node.left, sb);
			sb.append(":" + node.toString());
			this.inOrder(node.right, sb);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		inOrder(root, sb);
		return sb.toString();
		
	}
	
	
	
	
	
	
	private static class Node<E>{
		
		private E data;
		private Node<E> left, right;
		
		private Node(E inData) {
			this.data = inData;
			this.left = this.right = null;
			
			
		}
		
		public String toString() {
			return this.data.toString();
		}
		
	}

}

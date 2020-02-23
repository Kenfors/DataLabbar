package labb3;

import java.util.Random;

public class Tree {
	
	
	public Tree() {
		
	}
	
	
	public void run() {
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
			bst.add(new Integer(i));
			//bst.add(new Integer(rand.nextInt()%100));
		}
		
		for(int i = 9; i >= 0; i--) {
			//bst.delete(i);
			//bst.add(new Integer(rand.nextInt()%100));
			System.out.println(bst.maxRec());
		}
		System.out.println(bst.toString());
		
	}



}

package labb3;

import java.util.Random;

public class Radix {
	
	
	
	public Radix() {
		
	}
	
	public void run() {
		
		Random rand = new Random();
		int[] x = new int[1000000];
		for(int i=0; i<1000000;i++) x[i] = rand.nextInt(100000);
		
		this.sort(x);
		
	}
	
	
	
	public int[] sort(int[] arr) {
		
		int digits = getNoOfDigits(arr);

		for(int e=0; e<digits;e++) {
			arr = countSort(e, arr);
		}
		
		boolean done = true;

		for(int i=1; i < arr.length; i++) done &= (arr[i] >= arr[i-1]);		
		System.out.println("Sorting works? : " + done);

		
		
		return null;
	}
	
	private int getNoOfDigits(int[] arr) {
		int max = 0;
		for(int x : arr) {
			if(x > max) max = x;
		}
		int digits = 0;
		while (max > 0) {
			digits++;
			max /= 10;
		}
		
		return digits;
	}
	
	
	
	private int[] countSort(int digit, int[] original) {
		int[] sorted = new int[original.length];
		
		int[] idx = new int[] {0,0,0,0,0,0,0,0,0,0};
		
		for(int i=0; i<original.length; i++) idx[getDigit(digit, original[i])]++;
		
		for(int i=1; i<idx.length;i++) idx[i] += idx[i-1];
		
		for(int i=original.length-1;i>=0;i--) {
			idx[getDigit(digit, original[i])]--;
//			System.out.println("Index: " + idx[original[i]]);
			sorted[idx[getDigit(digit, original[i])]] = original[i];
		}
		
		
		return sorted;
	}
	
	private int getDigit(int expo, int num) {
		int digit = num / (int)Math.pow(10, expo);
		digit %= 10;
		//System.out.println("Digit: " + digit);
		
		
		return digit;
		
	}
	
	
	
	
	
	

}

package labb1;

import java.util.Iterator;
import java.util.Scanner;

import labb1.Uppgift1;
//import labb1.Uppgift2;
import labb1.Uppgift2b;
import labb1.Uppgift3;

public class RED1 {

	public static void main(String[] args) {

		
		// Alla labbar (tryck enter för gå till nästa)
		//labb1();
		
		//demoupg1();
		
		//demoupg3();
		
		
		red1_3();
			
		
	}
	
	/*
	 * + Iterable som interface
	 * - Remove ligger INTE i Iterator
	 * 
	 * tail kan inte hjälpa effektiviteten på remove()
	 * eftersom det bara finns referenser framåt
	 * och en Nod kan inte "ta bort sig själv"..
	 * 
	 * Inte debugat tail så mycket
	 * 
	 * */
	
	public static void red1() {
		Uppgift2b<String> l = new Uppgift2b<String>();
		
		for (int i = 0; i<4 ; i++) {
			l.add("e" + i);
		}
		l.remove(3);
		l.add(0, "först");
		l.add("sist");
		l.remove(0);
		l.remove(0);
		l.remove(0);
		l.remove(0);
		l.remove(0);
		l.add(0, "test"); //bara OM man tömmer lista, och väljer att placera på 0.
		l.add("test2");
		l.add("sist");
		System.out.println(l);
		
		
	}
	
	public static void red1_3() {
		Uppgift3<String> l = new Uppgift3<String>();
		
		for (int i = 0; i<4 ; i++) {
			l.add("e" + i);
		}
		Iterator<String> iter = l.iterator();
		
		iter.next();
		iter.remove();

		iter.remove();
		
		
		System.out.println(l);
		
	}
	
	
	
	public static void labb1() {
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		System.out.println("Uppgift1.\n");
		demoupg1();
		scan.nextLine();
		System.out.println("\n\nUppgift2.\n");
		demoupg2();
		scan.nextLine();
		System.out.println("\n\nUppgift3.\n");
		demoupg3();
		scan.close();
		
	};
	
	public static void demoupg2() {
		Uppgift2b<String> listclass = new Uppgift2b<String>();
		
		listclass.add("test1");
		listclass.add("test2");
		listclass.add("test3");
		listclass.add("test4");
		listclass.add("test5");
		System.out.println(listclass);
		for (String s : listclass) {
			System.out.println(s);
		}
		listclass.add(3, "addOnThree1");
		listclass.add(3, "addOnThree2");
		listclass.add(3, "addOnThree3");
		System.out.println(listclass);
		listclass.add(0, "AddOnFirst");
		listclass.add(listclass.size(), "AddOnLast");
		System.out.println(listclass);
		System.out.println("Removed: " + listclass.remove(0));
		System.out.println(listclass);
		System.out.println("Removed: " + listclass.remove(3));
		System.out.println("Removed: " + listclass.remove(3));
		System.out.println("Removed: " + listclass.remove(3));
		System.out.println(listclass);
		System.out.println("Remove last: " + listclass.remove(listclass.size()-1));
		System.out.println(listclass);
		System.out.println("Remove tail: " + listclass.remove(listclass.size()-1) + ", New tail:" + listclass.get(listclass.size()-1));
		System.out.println(listclass);
		System.out.println("Remove tail: " + listclass.remove(listclass.size()-1) + ", New tail:" + listclass.get(listclass.size()-1));
		System.out.println(listclass);
		System.out.println("Remove tail: " + listclass.remove(listclass.size()-1) + ", New tail:" + listclass.get(listclass.size()-1));
		System.out.println(listclass);
		System.out.println("Remove tail: " + listclass.remove(listclass.size()-1) + ", New tail:" + listclass.get(listclass.size()-1));
		System.out.println(listclass);
				
	}
	
	public static void demoupg3() {
		Uppgift3<String> listclass = new Uppgift3<String>();
		
		listclass.add("test1");
		listclass.add("test2");
		listclass.add("test3");
		listclass.add("test4");
		listclass.add("test5");
		System.out.println(listclass);
		for (String s : listclass) {
			System.out.println(s);
		}
		listclass.add(3, "addOnThree1");
		listclass.add(3, "addOnThree2");
		listclass.add(3, "addOnThree3");
		System.out.println(listclass);
		listclass.add(0, "AddOnFirst");
		listclass.add(listclass.size(), "AddOnLast");
		System.out.println(listclass);
		System.out.println("Removed: " + listclass.remove(0));
		System.out.println(listclass);
		System.out.println("Removed: " + listclass.remove(3));
		System.out.println("Removed: " + listclass.remove(3));
		System.out.println("Removed: " + listclass.remove(3));
		System.out.println(listclass);
		System.out.println("Remove: " + listclass.remove(listclass.size()-1));
		System.out.println(listclass);
		System.out.println("Remove: " + listclass.remove(listclass.size()-1) + ", New tail:" + listclass.get(listclass.size()-1));
		System.out.println(listclass);
		System.out.println("Remove: " + listclass.remove(listclass.size()-1) + ", New tail:" + listclass.get(listclass.size()-1));
		System.out.println(listclass);
		System.out.println("Remove: " + listclass.remove(listclass.size()-1) + ", New tail:" + listclass.get(listclass.size()-1));
		System.out.println(listclass);
		System.out.println("Remove: " + listclass.remove(listclass.size()-1) + ", New tail:" + listclass.get(listclass.size()-1));
		System.out.println(listclass);
		System.out.println("Remove: " + listclass.remove(listclass.size()-1));
		System.out.println(listclass);

				
	}
	
	public static void demoupg1() {
		Uppgift1 upg1 = new Uppgift1();
		
		System.out.println("" + "n\t" + " | " + "r");
		for(int i=1; i <= 20; i++)
			upg1.run(i);
		
	}

}

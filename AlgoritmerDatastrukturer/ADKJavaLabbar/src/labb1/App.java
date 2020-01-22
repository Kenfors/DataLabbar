package labb1;

import labb1.Uppgift1;
//import labb1.Uppgift2;
import labb1.Uppgift2b;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		demoUppgift2();
		
		//int i = 50;
		
		//while(i-- > 0) {
		//	System.out.println(i);
		//}
		
		
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
	public static void demoUppgift2() {
		Uppgift2b<String> upg2 = new Uppgift2b<String>();
		
		upg2.add("test1");
		upg2.add("test2");
		upg2.add("test3");
		upg2.add("test4");
		upg2.add("test5");
		System.out.println(upg2);
		for (String s : upg2) {
			System.out.println(s);
		}
		upg2.add(3, "addOnThree1");
		upg2.add(3, "addOnThree2");
		upg2.add(3, "addOnThree3");
		System.out.println(upg2);
		upg2.add(0, "AddOnFirst");
		upg2.add(upg2.size(), "AddOnLast");
		System.out.println(upg2);
		System.out.println("Removed: " + upg2.remove(0));
		System.out.println(upg2);
		System.out.println("Removed: " + upg2.remove(3));
		System.out.println("Removed: " + upg2.remove(3));
		System.out.println("Removed: " + upg2.remove(3));
		System.out.println(upg2);
		System.out.println("Remove last: " + upg2.remove(upg2.size()-1));
		System.out.println(upg2);
		System.out.println("Remove tail: " + upg2.remove(upg2.size()-1) + ", New tail:" + upg2.get(upg2.size()-1));
		System.out.println(upg2);
		System.out.println("Remove tail: " + upg2.remove(upg2.size()-1) + ", New tail:" + upg2.get(upg2.size()-1));
		System.out.println(upg2);
		System.out.println("Remove tail: " + upg2.remove(upg2.size()-1) + ", New tail:" + upg2.get(upg2.size()-1));
		System.out.println(upg2);
		System.out.println("Remove tail: " + upg2.remove(upg2.size()-1) + ", New tail:" + upg2.get(upg2.size()-1));
		System.out.println(upg2);
		
		
//		upg2.add("test4");
//		upg2.add("test5");
		
		
		
		
	}
	
	public static void demoUppgift1() {
		Uppgift1 upg1 = new Uppgift1();
		
		System.out.println("" + "n\t" + " | " + "r");
		for(int i=1; i <= 20; i++)
			upg1.run(i);
		
	}

}

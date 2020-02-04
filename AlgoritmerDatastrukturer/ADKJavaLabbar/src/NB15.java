import java.math.*;


public class NB15 {
	
	
	
	public static int getInteger(String num) {
		int expo = num.length()-1;
		int number = 0;
		System.out.println(expo);
		for(int i = 0;i < num.length();i++) {
			if(num.charAt(i) == 49) {
				number += Math.pow(2, expo);
			}
			expo--;
		}
		return number;
	}
	
	public static int getIntegerByte(String num) {
		
		int number = 0;
		for(int i = 0;i < num.length();i++) {
			number = number << 1;
			if(num.charAt(i) == 49) {
				number |= 1;
			}

		}
		return number;
	}
	
	public static int getIntegerRecursive(String num) {
		return iterate(num, 0);
	}
	
	public static int iterate(String num, int total) {
		if(num.charAt(0) == 49) {
			total |= 1;
		}
		num = num.substring(1);
		if (num.isEmpty()) return total;
		total = total << 1;
		return iterate(num, total);
	}
	
	
	public static String getByteString(int num) {
		
		
		
		return "";
	}
	public static String iterateNum(int num, int expo) {
		
		return "";
	}
	

}

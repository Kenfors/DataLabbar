package labb1;


public class Uppgift1 {
	
	
	public Uppgift1() {
		
		
		
	}
	
	public void run(int n) {
		
		int r = 0;
		
		for (int i=1; i <= n; i++) {
			for (int j=1; j <= i; j++) {
				for (int k=j; k <= j+i; k++) {
					for (int m=1; m <= i+j-k; m++) {
						r++;
					}
				}
			}
		}
		
		System.out.println("" + n + "\t | " + r);
		
		
	}

	
}

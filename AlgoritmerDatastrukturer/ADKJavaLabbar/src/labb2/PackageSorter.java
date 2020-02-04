package labb2;

public class PackageSorter {
	
	private int MAX;
	private String lastResult;
	private String lastLetters;
	
	public PackageSorter() {
		this.MAX = 13;
		this.lastLetters = "NONE";
		this.lastResult = "";
		
	}
	
	public void run(String startingorder) {
		this.lastLetters = startingorder;
		char[] letters = startingorder.toCharArray();
		
		String shift = this.shift(letters.clone(), "", 0);
		String flip = this.flip(letters.clone(), "");
		this.lastResult = (shift.length() < flip.length()) ? shift : flip;
	}
	
	public String toString() {
		String verbal = "Ordning: " + this.lastLetters;
		verbal += "\nTar " + this.lastResult.length() + " steg";
		return verbal;
	}
	
	private String shift(char[] letters, String moves, int halt) {
		if(halt >= 4) return "------------------------------------------------------";
		//System.out.println(moves + new String(letters));
		if(this.isDone(letters)) {
			System.out.println("Complete: " + moves);
			return moves;
		}
		char tmp = letters[4];
		letters[4] = letters[3];
		letters[3] = letters[2];
		letters[2] = letters[1];
		letters[1] = letters[0];
		letters[0] = tmp;
		
		String shift = this.shift(letters.clone(), new String(moves + "s"), halt + 1);
		String flip = this.flip(letters.clone(), new String(moves + "b"));
		//System.out.println((shift.length() < flip.length()) ? shift : flip);
		return (shift.length() < flip.length()) ? shift : flip;
	}
	
	private String flip(char[] letters, String moves) {
		//System.out.println(moves + new String(letters));
		if(this.isDone(letters)) {
			System.out.println("Complete: " + moves);
			return moves;
		}
		if(moves.length() >= MAX) return "------------------------------------------------------";
		
		char tmp = letters[0];
		letters[0] = letters[1];
		letters[1] = tmp;

		String s = this.shift(letters.clone(), new String(moves + "s"), 0);
		//System.out.println(moves);
		//System.out.println(s);
		return s;
	}
	
	private boolean isDone(char[] letters) {
		for(int i=0; i< letters.length-1; i++) {
			if(letters[i] > letters[i+1]) return false;
		}
		System.out.println("#####################################################################Done!");
		return true;
	}
	
	

}

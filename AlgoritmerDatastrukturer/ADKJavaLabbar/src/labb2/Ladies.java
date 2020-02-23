package labb2;

import java.util.ArrayList;
import java.util.List;

public class Ladies {
	
	private List<String> lastResult;
	
	public Ladies() {
		lastResult = new ArrayList<String>();
	}
	
	public void solve(int n) {
		
		// Make board.
		boolean[][] board = new boolean[n][n];
		for(int i = 0; i < n ; i++) {
			//board[i] = new boolean[n];
			for(int j = 0; j < n ; j++) {
				board[i][j] = true;
			}
		}
		
		placeNext(0, board, "");
		
	}
	
	private boolean placeNext(int r, boolean[][] board, String placed) {
		for(int k = 0; k<board[r].length;k++) {
			if(board[r][k]) {
				String newlyPlaced = placed;
				newlyPlaced += "(" + (r+1) + "," + (k+1) + ")";
				//if(r==board.length-2) {
				//	printBoard(board);
				//}
				if(r==board.length-1) {
					//printBoard(board);
					this.lastResult.add(newlyPlaced);
				}
				else {
					placeNext(r+1, placeQueenAlt(r, k, board), newlyPlaced);
				}				
			}
		}
		
		return false;
	}
	
	private boolean[][] placeQueen(int r, int k, boolean[][] inBoard){
		boolean[][] board = inBoard.clone();
		for(int row = 0; row < inBoard.length; row++) {
			board[row] = inBoard[row].clone();	
		}
		
		int i,j;
		for(i=0; i<board.length;i++) {
			board[i][k] = false;
			board[r][i] = false;
		}
		
		i = r; j = k;
		while(i * j > 0) {
			i--;
			j--;
		}
		while(i < board.length && j < board.length) {

			board[i][j] = false;
			i++;
			j++;
		}
		i = r; j = k;
		while(i >= 0 && j < board.length) {i--;j++;};
		while(i++ < board.length -1 && j-- > 0) {
			board[i][j] = false;
		}

		return board;
	}
	private boolean[][] placeQueenAlt(int r, int k, boolean[][] inBoard){
		boolean[][] board = inBoard.clone();
		for(int row = 0; row < inBoard.length; row++) {
			board[row] = inBoard[row].clone();	
		}
		
		int i,j;
		for(i=0; i<board.length;i++) {
			board[i][k] = false;
			board[r][i] = false;
		}
		
		i = r; j = k;
		while(i < board.length && j < board.length) {

			board[i][j] = false;
			i++;
			j++;
		}
		i = r; j = k;
		while(i++ < board.length -1 && j-- > 0) {
			board[i][j] = false;
		}

		return board;
	}
	
	public void run(int n) {
		
		// Make board.
		boolean[][] board = new boolean[n][n];
		for(int i = 0; i < n ; i++) {
			//board[i] = new boolean[n];
			for(int j = 0; j < n ; j++) {
				board[i][j] = true;
			}
		}
		
		
		
		
	}
	
	private void printBoard(boolean[][] board) {
		String str = "\n";
		for(int i = 0; i < board.length ; i++) {
			for(int j = 0; j < board.length ; j++) {
				str += (board[i][j]) ?  "| ": "|X";
			}
			str += "|\n";
		}
		
		
		str += "\n";
		System.out.println(str);
	}
	
	public String getResults() {
		
		return "";
	}
	
	public String toString() {
		String s = "";
		//for (int i = 0; i < this.lastResult.size(); i++) {
		//	s += this.lastResult.get(i) + "\n";
		//}
		
		s += "\nNumber of solutions: " + this.lastResult.size();
		
		return s;
	}
	
	
	
	
	
}

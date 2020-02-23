package labb3;

import java.util.ArrayList;
import java.util.Scanner;

public class Puzzle {
	
	
	private int[][] board;
	
	private ArrayList<ArrayList<Piece>> solutions;
	
	public Puzzle() {
		this.board = new int[][] {
			new int[] {0,0,0,0,0},
			new int[] {0,0,0,0,0},
			new int[] {0,0,0,0,0},
			new int[] {0,0,0,0,0},
			new int[] {0,0,0,0,0},
		};
		this.solutions = new ArrayList<ArrayList<Piece>>();
	}
	
	public void run(int x, int y) {
		x--;y--;
		this.board[x][y] = 9;

		ArrayList<Piece> all = this.buildPieces();
		ArrayList<Piece> placed = new ArrayList<Piece>();

		Piece q = all.get(0);
		Piece w = all.get(1);
		Piece e = all.get(2);
		Piece r = all.get(3);
		

		for(Piece p : all) {
			if(p.isColliding(x, y))
				placed.add(p);
		}
		all.removeAll(placed);
		placed.clear();
		
		if(!q.isColliding(x, y)) {
			q.addToBoard(1, all);
			placed.add(q);
			place(all, placed, 1);
			placed.remove(q);
			q.removeFromBoard(all);			
		}
		
		if(!w.isColliding(x, y)) {
			w.addToBoard(1, all);
			placed.add(w);
			place(all, placed, 1);
			placed.remove(w);
			w.removeFromBoard(all);			
		}
		
		if(!e.isColliding(x, y)) {
			e.addToBoard(1, all);
			placed.add(e);
			place(all, placed, 1);
			placed.remove(e);
			e.removeFromBoard(all);
		}
		
		if(!r.isColliding(x, y)) {
			r.addToBoard(1, all);
			placed.add(r);
			place(all, placed, 1);
			placed.remove(r);
			r.removeFromBoard(all);
		}
		
		System.out.println();
		System.out.println("Solutions: " + this.solutions.size() + "\n");
		this.ShowSolutions();
		
	}
	
	private void place(ArrayList<Piece> remaining, ArrayList<Piece> placed, int n) {
		ArrayList<Piece> adjacent = new ArrayList<Piece>();
		
		//System.out.println("\nremaining:" + remaining.size());
		//System.out.println("placed:" + placed.size());
		
		if(n == 8) addSolution((ArrayList<Piece>) placed.clone());
		if(remaining.size() == 0) return;
		
		
		//Faster but misses...
		/*
		for(Piece p : placed) {
			for(Piece avail : remaining) {
				if(p.isAdjacent(avail) && !adjacent.contains(avail)) {
					adjacent.add(avail);
				}
			}
		}
		*/
		
		adjacent = (ArrayList<Piece>) remaining.clone();
		
		//System.out.println("adjacent: " + adjacent.size());
		
		for(Piece next : adjacent) {
			next.addToBoard(n+1, remaining);
			placed.add(next);
			if(n > 9)
				System.out.println(this);				
			this.place(remaining, placed, n+1);
			next.removeFromBoard(remaining);
			placed.remove(next);
		}
		
		
		
	}
	
	private void addSolution(ArrayList<Piece> placed) {
		for(ArrayList<Piece> sol : this.solutions) {
			if(sol.containsAll(placed)) {
				//System.out.println("dupe");
				return;
			} 	
		}
		this.solutions.add(placed);
	}
	
	private ArrayList<Piece> buildPieces() {
		ArrayList<Piece> all = new ArrayList<Piece>();
		
		
		int x1, y1;
		int x2, y2;
		int x3, y3;
		
		for(int x = 0; x < 4; x++)
			for(int y=0; y <4; y++) {
				x1 = 0; y1 = 0;
				x2 = 0; y2 = 1;
				x3 = 1; y3 = 0;
				all.add(new Piece(x+x1,y+y1,x+x2,y+y2,x+x3,y+y3));

				x1 = 0; y1 = 1;
				x2 = 1; y2 = 0;
				x3 = 1; y3 = 1;
				all.add(new Piece(x+x1,y+y1,x+x2,y+y2,x+x3,y+y3));
				
				x1 = 0; y1 = 0;
				x2 = 1; y2 = 0;
				x3 = 1; y3 = 1;
				all.add(new Piece(x+x1,y+y1,x+x2,y+y2,x+x3,y+y3));
				
				x1 = 0; y1 = 0;
				x2 = 0; y2 = 1;
				x3 = 1; y3 = 1;
				all.add(new Piece(x+x1,y+y1,x+x2,y+y2,x+x3,y+y3));
				
			}
		
		return all;
	}
	
	public void ShowSolutions() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Piece> remaining = new ArrayList<Piece>();
		int i = 0;
		String s = "";
		for(ArrayList<Piece> sol : this.solutions) {
			for(Piece p : sol) {
				p.addToBoard(i++, remaining);
			}
			System.out.println(this);
			for(Piece p : sol) {
				p.removeFromBoard(remaining);
			}
			i = 0;
			System.out.println("Enter...");
			s = scan.nextLine();
		}
		
		
	}
	
	public String toString() {
		String s = "";
		
		for(int i=0; i<board.length;i++) {
			for(int j=0; j<board.length;j++) {
				s += "[" + board[i][j] + "]";
			}
			s += "\n";
		}
		
		return s;
	}
	
	private class Piece {
		int ax, ay;
		int bx, by;
		int cx, cy;
		
		ArrayList<Piece> blockedPieces;
		
		public Piece(int x1, int y1, int x2, int y2, int x3, int y3) {
			ax = x1; ay = y1;
			bx = x2; by = y2;
			cx = x3; cy = y3;
			this.blockedPieces = new ArrayList<Piece>();
			
		}
		
		public boolean isPossible() {
			boolean b = true;
			b &= board[ax][ay] == 0;
			b &= board[bx][by] == 0;
			b &= board[cx][cy] == 0;
			return b;
		}
		
		public void addToBoard(int id, ArrayList<Piece> remaining) {
			board[ax][ay] = id;
			board[bx][by] = id;
			board[cx][cy] = id;
			
			for (Piece p : remaining) {
				if(this.isColliding(p)) {
					this.blockedPieces.add(p);
				}
			}
			remaining.removeAll(this.blockedPieces);
			
		}
		
		public void removeFromBoard(ArrayList<Piece> remaining) {
			board[ax][ay] = 0;
			board[bx][by] = 0;
			board[cx][cy] = 0;
			
			remaining.addAll(this.blockedPieces);
			this.blockedPieces.clear();
			
		}
		
		public boolean isAdjacent(Piece other) {
			int dx = this.ax - other.ax;
			int dy = this.ay - other.ay;
			
			boolean adjacent = true;
			adjacent &= (dx*dx) < 5;
			adjacent &= (dy*dy) < 5;
			adjacent &= (dx*dy) != 0;
			
			// Might not be necessary
			//adjacent |= (dx * dx == 4 && dy*dy == 0);
			//adjacent |= (dy * dy == 4 && dx*dx == 0);
			
			return adjacent;
		}
		
		public boolean isColliding(Piece other) {
			boolean collision = false;
			
			collision |= this.ax == other.ax && this.ay == other.ay;
			collision |= this.ax == other.bx && this.ay == other.by;
			collision |= this.ax == other.cx && this.ay == other.cy;
			if(collision) return true;
			
			collision |= this.bx == other.ax && this.by == other.ay;
			collision |= this.bx == other.bx && this.by == other.by;
			collision |= this.bx == other.cx && this.by == other.cy;
			if(collision) return true;
			
			collision |= this.cx == other.ax && this.cy == other.ay;
			collision |= this.cx == other.bx && this.cy == other.by;
			collision |= this.cx == other.cx && this.cy == other.cy;			
			return collision;
			
		}
		
		public boolean isColliding(int x, int y) {
			boolean collision = false;
			
			collision |= this.ax == x && this.ay == y;
			collision |= this.bx == x && this.by == y;
			collision |= this.cx == x && this.cy == y;
			return collision;
			
		}
		
	}
	
	
}

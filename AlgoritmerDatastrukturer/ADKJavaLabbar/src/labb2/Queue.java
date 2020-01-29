package labb2;

public class Queue {
	
	private QueueNode freeSpot;
	private QueueNode nextSpot;
	
	
	public Queue() {
		this.nextSpot = null;
		this.freeSpot = null;
	}
	
	public void push() {
		if(nextSpot == null) {
			this.nextSpot = new QueueNode();
			this.freeSpot = this.nextSpot.next();
			return;
		}
		this.freeSpot = new QueueNode();
		this.freeSpot = this.freeSpot.next;
	}
	
	public void tick() {
		if(this.nextSpot.decrement() == 0) {
			this.nextSpot = this.nextSpot.next();
		}
		
	}
	public boolean hasNext() {return this.nextSpot != null;}
	
	
	private class QueueNode {
		
		private int steps;
		private QueueNode next;
		
		public QueueNode() {
			this.steps = 4;
			this.next = null;
		
		}
		
		public int decrement() {
			return --this.steps;
		}
		
		public QueueNode next() { return this.next;}
		
		
		
	}

}

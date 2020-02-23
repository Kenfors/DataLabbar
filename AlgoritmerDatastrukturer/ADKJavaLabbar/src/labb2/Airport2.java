package labb2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class Airport2 {

	private Queue<Plane> takeoffs;
	private Queue<Plane> arrivals;
	
	private int arrivalWaitTimeTotal;
	private int arrivalWaitTimeMax;
	private int arrivalNoOfPlanes;
	
	private int takeoffWaitTimeTotal;
	private int takeoffWaitTimeMax;
	private int takeoffNoOfPlanes;
	
	public Airport2() {
		this.arrivals = new LinkedList<Plane>();
		this.takeoffs = new LinkedList<Plane>();
		
		this.arrivalWaitTimeMax = 0;
		this.arrivalWaitTimeTotal = 0;
		this.arrivalNoOfPlanes = 0;
		
		this.takeoffWaitTimeMax = 0;
		this.takeoffWaitTimeTotal = 0;
		this.takeoffNoOfPlanes = 0;
		
	}
	
	public void runTest() {
		

		this.addTakeoff();
		this.tick();
		this.tick();
		this.addTakeoff();
		this.addTakeoff();
		this.addTakeoff();
		this.addTakeoff();
		this.addTakeoff();
		//arrivals.add(new Plane(this.takeoffs.size()*4));
		//arrivalNoOfPlanes++;
		//arrivals.add(new Plane(this.takeoffs.size()*4));
		//arrivalNoOfPlanes++;
		this.tick();
		this.tick();
		this.tick();
		this.tick();
		
		while(!this.arrivals.isEmpty() || !this.takeoffs.isEmpty()) {
			this.tick();
		}


		String maxWaitLanding = "" + this.arrivalWaitTimeMax;
		String maxWaitLifting = "" + this.takeoffWaitTimeMax;
		float avgWaitTimeLanding = (float)(this.arrivalWaitTimeTotal) / (float)this.arrivalNoOfPlanes;
		//avgWaitTimeLanding *= 5.0;
		float avgWaitTimeLifting = (float)(this.takeoffWaitTimeTotal) / (float)this.takeoffNoOfPlanes;
		//avgWaitTimeLifting *= 5.0;
		
		System.out.println();
		System.out.println("Arrivals:" + this.arrivalNoOfPlanes);
		System.out.println("Takeoffs:" + this.takeoffNoOfPlanes);
		
		System.out.println();
		System.out.println("Max wait arrivals:" + maxWaitLanding);
		System.out.println("Max wait takeoffs:" + maxWaitLifting);
		System.out.println();
		System.out.println("Avg wait arrivals:" + avgWaitTimeLanding + " minuter");
		System.out.println("Avg wait takeoffs:" + avgWaitTimeLifting + " minuter");
		
		
	}
	
	private void addArrival() {
		Plane p = new Plane(this.arrivals.size() * 4);
		this.arrivals.add(p);
		if(this.arrivals.peek().inProgress()) {
			p.holdtime -= (4 - this.arrivals.peek().progress);
		}
		arrivalNoOfPlanes++;
			
	}
	
	private void addTakeoff() {
		Plane p = new Plane(this.takeoffs.size() * 4);
		this.takeoffs.add(p);
		if(this.takeoffs.peek().inProgress()) {
			p.holdtime -= (4 - this.takeoffs.peek().progress);
		}
		takeoffNoOfPlanes++;
		
	}
	
	public void runSim(int years) {
		
		int noOfTicks = years * 365;
		noOfTicks *= 24;
		noOfTicks *= 12;
		
		System.out.println();
		//System.out.println("Antal ticks:" + noOfTicks);
		
		Random rand = new Random();
		for(int i = 0; i < noOfTicks; i++) {
			
			if (i == 1) {
				this.addArrival();
			}
			if (i == 2) {
				this.addTakeoff();
			}
			this.tick();
		}
		
		String maxWaitLanding = "" + this.arrivalWaitTimeMax * 5 + " minuter";
		String maxWaitLifting = "" + this.takeoffWaitTimeMax * 5 + " minuter";
		float avgWaitTimeLanding = (float)(this.arrivalWaitTimeTotal) / (float)this.arrivalNoOfPlanes;
		avgWaitTimeLanding *= 5.0;
		float avgWaitTimeLifting = (float)(this.takeoffWaitTimeTotal) / (float)this.takeoffNoOfPlanes;
		avgWaitTimeLifting *= 5.0;
		
		System.out.println();
		System.out.println("Arrivals:" + this.arrivalNoOfPlanes);
		System.out.println("Takeoffs:" + this.takeoffNoOfPlanes);
		
		System.out.println();
		System.out.println("Max wait arrivals:" + maxWaitLanding);
		System.out.println("Max wait takeoffs:" + maxWaitLifting);
		System.out.println("Avg wait arrivals:" + avgWaitTimeLanding + " minuter");
		System.out.println("Avg wait takeoffs:" + avgWaitTimeLifting + " minuter");
		
	}
	
	public void tick() {

		//PRIO
		// 1. (PROGRESS?) HÅLLER NÅGON PÅ ATT LANDA/LYFTA? -> GÖR KLART.
		// 2. (NO PROGRESS)
			// a. RUN LANDA -> HOLD LYFTA	
			// b. RUN LYFTA -> HOLD LANDA
		
		//Handle wait times...
		
		// Hantera ena.
		int planeTime = 0;
		if (!this.arrivals.isEmpty()) {
			if (!this.takeoffs.isEmpty() && this.takeoffs.peek().inProgress()) {
				planeTime = this.run(this.takeoffs);
				if(planeTime > this.takeoffWaitTimeMax) {
					this.takeoffWaitTimeMax = planeTime;
					
				}
				this.takeoffWaitTimeTotal += planeTime;
				this.hold(this.arrivals);
			}
			else {
				planeTime = this.run(this.arrivals);
				if(planeTime > this.arrivalWaitTimeMax) {
					this.arrivalWaitTimeMax = planeTime;
					
				}
				this.arrivalWaitTimeTotal += planeTime;
				this.hold(this.takeoffs);
			}
		}
		else if (!this.takeoffs.isEmpty()) {
			planeTime = this.run(this.takeoffs);
			if(planeTime > this.takeoffWaitTimeMax) {
				this.takeoffWaitTimeMax = planeTime;
				
			}
			this.takeoffWaitTimeTotal += planeTime;
			this.hold(this.arrivals);
		}
		
		
	}
	
	public int run(Queue<Plane> planeQueue) {
		Plane p = planeQueue.peek();
		if (p == null) return 0;
		p.run();
		if (p.isDone()) {return planeQueue.poll().totalTime();}
		return 0;
		
	}
	
	public void hold(Queue<Plane> planeQueue) {
		for(Plane p : planeQueue) {
			p.holdtime++;
		}
	}
	
	
	private class Plane {
		private int progress;
		private int holdtime;
		
		public Plane(int queuelength) {
			this.progress = 4;
			this.holdtime = queuelength;
		}
		
		public int getTotalWaitTime() {return this.holdtime;}
		
		public boolean inProgress() { return this.progress < 4;}
		public boolean isDone() { return this.progress == 0;}
		public int totalTime() {return this.holdtime;}
		public void run() {this.progress--;}
		
		public String toString() {
			
			return "";
		}
	}
	
	
}

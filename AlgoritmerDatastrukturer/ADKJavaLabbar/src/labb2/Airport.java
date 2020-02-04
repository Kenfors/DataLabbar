package labb2;

import java.util.Random;
import java.util.Queue;

public class Airport {
	
	
	private PlaneQueue arrivals;
	private PlaneQueue departures;
	
	
	public Airport() {
		
		this.arrivals = new PlaneQueue();
		this.departures = new PlaneQueue();
		
		// Behövs queue, eller kan man använda int, och addera 4 (5-minutare)
		
	}
	
	public void runTest() {
		

		departures.put();
		departures.put();
		departures.put();
		this.tick();
		arrivals.put();
		this.tick();
		this.tick();
		this.tick();
		this.tick();
		this.tick();
		this.tick();
		this.tick();
		this.tick();
		arrivals.put();
		this.tick();
		departures.put();
		
		while(this.arrivals.planes > 0 || this.departures.planes > 0) {
			this.tick();
		}


		
		System.out.println("Arrivals: " + this.arrivals);
		System.out.println("Departur: " + this.departures);
		
		
	}
	
	public void runSim(int years) {
		
		int noOfTicks = years * 365;
		noOfTicks *= 24;
		noOfTicks *= 12;
		
		System.out.println();
		System.out.println("Antal ticks:" + noOfTicks);
		
		Random rand = new Random();
		for(int i = 0; i < noOfTicks; i++) {
			
			if (rand.nextInt(100) < 5) {
				arrivals.put();
			}
			if (rand.nextInt(100) < 5) {
				departures.put();
			}
			this.tick();
		}
		
		String maxWaitLanding = "" + this.arrivals.waitTimeMax;
		String maxWaitLifting = "" + this.departures.waitTimeMax;
		float avgWaitTimeLanding = (float)(this.arrivals.waitTimeTotal) / (float)this.arrivals.noOfPlanes;
		avgWaitTimeLanding *= 5.0;
		float avgWaitTimeLifting = (float)(this.departures.waitTimeTotal) / (float)this.departures.noOfPlanes;
		avgWaitTimeLifting *= 5.0;
		
		System.out.println();
		System.out.println("Antal plan:" + this.arrivals.noOfPlanes);
		
		System.out.println();
		System.out.println("Max wait arrivals:" + maxWaitLanding);
		System.out.println("Max wait takeoffs:" + maxWaitLifting);
		System.out.println("Avg wait arrivals:" + avgWaitTimeLanding);
		System.out.println("Avg wait takeoffs:" + avgWaitTimeLifting);
	}
	
	
	public void tick() {
		
		//PRIO
		// 1. (PROGRESS?) HÅLLER NÅGON PÅ ATT LANDA/LYFTA? -> GÖR KLART.
		// 2. (NO PROGRESS)
			// a. RUN LANDA -> HOLD LYFTA	
			// b. RUN LYFTA -> HOLD LANDA
		
		//Handle wait times...
		
		// Hantera ena.
		if(this.arrivals.inProgress()) { 
			this.arrivals.run();
			this.departures.hold();
		}
		// Hantera andra. Det är antingen ena eller andra alltid.
		else if (this.departures.inProgress()) {
			this.departures.run();
			this.arrivals.hold();
		}
		// Ny landning. OM det finns
		else if (this.arrivals.run()) {
			this.departures.hold();
		}
		// Ny landning. OM det finns
		else {
			this.departures.run();
			this.arrivals.hold();
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
		
		public String toString() {
			
			return "";
		}
	}
	
	private class PlaneQueue {
		
		private int planes;
		private int noOfPlanes;
		private int waitTimeTotal;
		private int waitTimeMax;
		private int currentWait;
		
		
		public PlaneQueue() {
			this.planes = 0;
			this.noOfPlanes = 0;
			this.waitTimeMax = 0;
			this.waitTimeTotal = 0;
			this.currentWait = 0;
		}
		
		// Lägger till plan i kön.
		// 
		public void put() {
			if(this.planes > 0) {
				this.waitTimeTotal += planes;
				if(this.planes > this.waitTimeMax) {
					this.waitTimeMax = this.planes;
				}
			}
			this.planes += 4;
			this.noOfPlanes++;
		}
		
		public boolean inProgress() {return (this.planes % 4) != 0;}
		
		public boolean run() {
			if(this.planes == 0) return false;
			this.planes--;
			return true;
		}
		
		public void hold() {
			if (this.planes == 0) return; //ingen väntar
			this.waitTimeTotal += (planes / 4); //Varje plan väntar 5min extra.
		}
		
		public String toString() {
			String str = "Plane Queue\n";
			str += "Current queue time: " + this.planes + "\n";
			str += "Total wait time: " + this.waitTimeTotal + "\n";
			str += "MAX.  wait time: " + this.waitTimeMax + "\n";
			str += "Total planes: " + this.noOfPlanes + "\n";
			return str;
		}
		
		
		
	}
	

}

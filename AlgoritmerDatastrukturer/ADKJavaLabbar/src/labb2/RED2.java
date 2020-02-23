package labb2;

public class RED2 {

	public static void main(String[] args) {

		//upg4();
		//upg5();
		upg6();
		
	}
	
	public static void upg4() {
		
		Airport2 planes = new Airport2();
		planes.runSim(10);
		//planes.runTest();
		
	}
	
	public static void upg5() {
		
		PackageSorter pkt = new PackageSorter(false);
		
		pkt.run("EADBC");
		System.out.println(pkt);
		
	}
	
	public static void upg6() {
		
		Ladies chess = new Ladies();
		
		chess.solve(15);
		System.out.println(chess);
		
	}

}

package labb2;

public class RED2 {

	public static void main(String[] args) {

		upg5();
		
	}
	
	public static void upg4() {
		
		Airport2 planes = new Airport2();
		planes.runSim(1000);
		//planes.runTest();
		
	}
	
	public static void upg5() {
		
		PackageSorter pkt = new PackageSorter();
		
		pkt.run("BECAD");
		System.out.println(pkt);
		
	}

}

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
public class HoofPaperScissors {
	
	public static void main(String[] args) {
		Batl bat = new Batl();
		bat.run();
	}
		
	public void run() {
		File into = null;	
		Scanner in = null;	
		PrintWriter out = null;
		
		try {
			into = new File("tallbarn.in");	
			in = new Scanner(into);	
			out = new PrintWriter("tallbarn.out");
		} catch(FileNotFoundException e) {}
		
		int numFloors = in.nextInt();
		int numCows = in.nextInt();
		
		int[] floors = new int[numFloors];
		for(int i = 0; i < numFloors; i++) {
			floors[i] = in.nextInt();
		}
		
		int[] useCows = new int[numFloors];
		int min = 0;
		for(int i = 0; i < floors.length; i++) {
			if(min > floors[i])
				min = floors[i];
		}
		
		double[] fracResults = new double[numFloors];
		for()
		
		
		
	}
}
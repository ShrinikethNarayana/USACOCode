import java.util.*;
import java.io.*;
public class Crossings {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	public static void main(String[] args) {
		Crossings bat = new Crossings();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("crossings.in");	
			in = new Scanner(into);	
			out = new PrintWriter("crossings.out");
		} catch(FileNotFoundException e) {}
	
		int numCows = in.nextInt();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int[] cowsStart = new int[numCows];
		
		for(int i = 0; i < numCows; i++) {
			cowsStart[i] = in.nextInt();
			map.put(cowsStart[i], in.nextInt());
		}
		
		Arrays.sort(cowsStart);
		
		int max = map.get(cowsStart[0]);
		ArrayList<Integer> mins = new ArrayList<Integer>();
		boolean[] safe = new boolean[numCows];
		for(int i = 0; i < numCows; i++) {
			safe[i] = true;
		}
		
		
		
		for(int i = 0; i < ) {
			mins.add(map.get(cowsStart[i]));
			int theCurrent = min.get(i);
			if(theCurrent > max) {
				max = theCurrent;
			} 
			else {
				int min = -1000001;
				int index = i;
				while( theCurrent > min && index >= 0) {
					min = mins.get(index) > min ? mins.get(index): min;
					index--;
				}
				
				mins.add(mins.remove(i), index);
				for(int j = )
			}

		
		}
	
		
		out.close();
	}
	
	
}
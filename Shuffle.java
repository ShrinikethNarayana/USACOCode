
import java.util.*;
import java.io.*;
public class Shuffle {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	int numCows;
	public static void main(String[] args) {
		Shuffle bat = new Shuffle();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("shuffle.in");	
			in = new Scanner(into);	
			out = new PrintWriter("shuffle.out");
		} catch(FileNotFoundException e) {}
		
		numCows = in.nextInt();
		//in.nextInt();
		
		int[] shuffling = new int[numCows];
		for(int i = 0; i < numCows; i++) {
			shuffling[i] = in.nextInt()-1;
		}
		
		HashSet<Integer>[] goingTo = new HashSet<Integer>[numCows];
		boolean empty = new boolean[numCows];
		ArrayList<Integer> flagged = new ArrayList<Integer>();
		
		
		
		for(int i = 0; i < numCows; i++) {
			if(!empty[i]) {
				if(goingTo[i].isEmpty()) {
					int currentOne = 0;
					while() {
						if(goingTo[shuffling[currentOne]].size() == 1) {
							empty[currentOne] = true;
							currentOne = shuffling[currentOne];
						}
						else {
							flagged.add(goingTo[shuffling[currentOne]])
							break;
						}
					}			
				}
			}
		}
		
		boolean allGood = true;
		while(flagged.size() == 0 && allGood) {
			for(Integer i: goingTo[count]) {
				
			}
		}
		
		
		out.print(alwaysFull.size());
		out.close();
		//boolean[] cows = new boolean[numCows];
		//for()
		
		
	}
	
	
}
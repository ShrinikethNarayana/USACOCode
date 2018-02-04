
import java.util.*;
import java.io.*;
public class Homework {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	int numProb;
	public static void main(String[] args) {
		Homework bat = new Homework();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("homework.in");	
			in = new Scanner(into);	
			out = new PrintWriter("homework.out");
		} catch(FileNotFoundException e) {}
		
		numProb = in.nextInt();
		//PriorityQueue<Integer> queue = new PriorityQueue<Integer>(numProb);
		int[] problems = new int[numProb];  //sorted array
		int[] problems2 = new int[numProb]; //unsorted array
		
		int min = 10001;
		int[] mins = new int[numProb];
		for(int i = 0; i < numProb; i++) {
			problems[i] = in.nextInt();
		}
		
		for(int i = numProb-1; i>= 0; i--) {
			problems2[i] = problems[i];
			if(min > problems[i]) {
				min = problems[i];
			}
			mins[i] = min;
			if(i != numProb-1)
				problems2[i] += problems2[i+1];
			
		}
		
		double[] avg = new double[numProb];
		
		for(int i = 1; i < numProb-1; i++) {
			avg[i] = (double)(problems2[i]-mins[i])/(numProb-i-1);
		}
	//	for(int i: avg)
			//System.out.println(i);
		
		
		ArrayList<Integer> best = new ArrayList<Integer>();
		double bestest = -1.0;
		
		for(int i = 1; i < numProb-1; i++) {
			if(avg[i] > bestest) {
				bestest = avg[i];
				best = new ArrayList<Integer>();
				best.add(i);
			}
			else if(avg[i] == bestest) {
				best.add(i);
			}
			
		}
		
		for(Integer i: best) {
			out.println(i);
		}
		
		out.close();
	
	}
	
	
}
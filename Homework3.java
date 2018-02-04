import java.util.*;
import java.io.*;
public class Homework3 {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	int numProb;
	public static void main(String[] args) {
		Homework3 bat = new Homework3();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("homework.in");	
			in = new Scanner(into);	
			out = new PrintWriter("homework.out");
		} catch(FileNotFoundException e) {}
		
		numProb = in.nextInt();
		
		int[] problems = new int[numProb];
		int minIndex = -1;
		int sum = 0;
		
		int minVal = Integer.MAX_VALUE;
		for(int i = 0; i < numProb; i++) {
			problems[i] = new Integer(in.nextInt());
			if(problems[i] < minVal){
				minVal = problems[i];
				minIndex = i;
			}
			if(i != 0)
				sum += problems[i];
		}
		sum -= minVal;
		
		int avg = sum/(numProb-1);
		int maxAvg = avg;
		int [] averages = new int[numProb];
		for(int i = 2; i < numProb-2; i++){
			if(problems[i] < avg){
				averages[i-1] = sum/(numProb-i+1); //average of previous item
				if(averages[i-1] > avg)
					avg = averages[i-1];
			}
			sum -= problems[i];
			
			if(i == minIndex){ //removed previosly worst score
				sum += problems[i];
				minVal = Integer.MAX_VALUE;
				for(int j = i+1; j < numProb; j++){ //find the next worst score going forward
					if(problems[j] < minVal){
						minVal = problems[j];
						minIndex = j;
					}
				}
				sum -= minVal;
			}
			
		}
		
		//Look at each avg in list and find max values
		maxAvg = 0;
		ArrayList<Integer> eaten = new ArrayList<Integer>();
		for(int i = 1; i < numProb-2; i++){
			if(averages[i] > maxAvg){
				maxAvg = averages[i];
				eaten.clear();
				eaten.add(i);
			}else if(averages[i] == maxAvg)
				eaten.add(i);
		}
		
		String s = "";
		for(int i : eaten)
			s += (i+" ");
		out.print(s.trim());
		out.close();
	}
}
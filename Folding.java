import java.util.*;
import java.io.*;
public class Folding {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	public static void main(String[] args) {
		Folding bat = new Folding();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("Folding.in");	
			in = new Scanner(into);	
			out = new PrintWriter("Folding.out");
		} catch(FileNotFoundException e) {}
	
		int numKnots = in.nextInt();
		int theLength = in.nextInt();
		
		int[] knots = new int[numKnots+2];
		knots[0] = 0;
		for(int i = 0; i < numKnots; i++) {
			knots[i+1] = in.nextInt();
		}
		knots[numKnots+1] = theLength;
		
		int counter = 0;
		for(int i = 0; i < numKnots+1; i++) {
			int knot1 = knots[i];
			int knot2 = knots[i+1];
			double middle = (knot1+knot2)/2;
			
			boolean works = true;
			int max = (i+1 < numKnots+1-i) ? i+1: numKnots+1-i;
			for(int j = 0; j < max; j++) {
				if(knots[i-j]-middle != -1*(knots[i+j+1]-middle))
					works = false;
				
			}
			if(works) {
				counter++;
				System.out.println(middle);
			}
		}
		
		
		for(int i = 0; i < numKnots; i++) {
			double knot1 = knots[i+1];
			
			boolean works = true;
			int max = (i+1 < numKnots-2-i) ? i+1: numKnots-2-i;
			for(int j = 0; j < max; j++) {
				if(knots[i-j]-knot1 != -1*(knots[i+j+2]-knot1))
					works = false;
				
			}
			if(works) {
				counter++;
				System.out.println(knot1);
			}
		}
	
		out.print(counter);
		out.close();
	}
	
	
}
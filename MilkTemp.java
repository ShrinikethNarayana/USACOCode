
import java.util.*;
import java.io.*;
public class MilkTemp {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	int numCows;
	public static void main(String[] args) {
		MilkTemp bat = new MilkTemp();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("milktemp.in");	
			in = new Scanner(into);	
			out = new PrintWriter("milktemp.out");
		} catch(FileNotFoundException e) {}
		
		numCows = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int z = in.nextInt();

		int milk = x*numCows;
		int[] beg = new int[numCows];
		int[] end = new int[numCows];
		for(int i = 0; i < numCows; i++) {
			beg[i] = in.nextInt();
			end[i] = in.nextInt()+1;
		}
		
		Arrays.sort(beg);
		Arrays.sort(end);
		int maxMilk = milk;
		
		int begInd = 0;
		int endInd = 0;
		int begOne;
		int endOne;
		while(begInd < numCows || endInd < numCows) {
			if(begInd == numCows) {
				endOne = end[endInd];
				endInd++;
					milk += z-y;
					if(milk > maxMilk)
						maxMilk = milk;
			}
			else if(endInd == numCows) {
				begOne = beg[begInd];
				begInd++;
					milk += y-x;
					if(milk > maxMilk)
						maxMilk = milk;
			}
			else {
				begOne = beg[begInd];
				endOne = end[endInd];
				
				if(begOne < endOne) {
					begInd++;
					milk += y-x;
					if(milk > maxMilk)
						maxMilk = milk;
				}
				
				else if(endOne < begOne) {
					endInd++;
					milk += z-y;
					if(milk > maxMilk)
						maxMilk = milk;
				}
				
				else {
					begInd++;
					endInd++;
					milk += y-x;
					milk += z-y;
					if(milk > maxMilk)
						maxMilk = milk;
				}
			}
		}
		
		out.print(maxMilk);
		out.close();
		
		
	}
	
	
}
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Div7 {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int[] cows;
	int numCows;
	public static void main(String[] args) {
		Div7 bat = new Div7();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("div7.in");	
			in = new Scanner(into);	
			out = new PrintWriter("div7.out");
		} catch(FileNotFoundException e) {}
		
		
		numCows = in.nextInt();
		cows = new int[numCows];
		cows[0] = in.nextInt()%7;
		for(int i = 1; i < numCows; i++)
			cows[i] = (cows[i-1]+in.nextInt())%7;
			
		
		int max = 0;
		for(int i = 0; i < numCows; i++) {
			if(cows[i]==0)
				max = i+1;
		}
		
		for(int i: cows)
			System.out.println(i);
		int[] firstOfEach = new int[7];
		
		for(int i = numCows-1; i >= 0; i--) {
			System.out.println(i);
			firstOfEach[cows[i]] = i;
		}
		
		int[]lastOfEach = new int[7];
		for(int i = 0; i < numCows; i++) {
			lastOfEach[cows[i]] = i;
		}
		
	
		for(int i = 0; i < 7; i++) {
			if(lastOfEach[i]-firstOfEach[i] > max)
				max = lastOfEach[i]-firstOfEach[i];
		}
		
		
		out.println(max);
		out.close();
		
		
	}
	
	
}
		
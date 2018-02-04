import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class CowJog {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int[] cows;
	int numCows;
	public static void main(String[] args) {
		CowJog bat = new CowJog();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("cowjog.in");	
			in = new Scanner(into);	
			out = new PrintWriter("cowjog.out");
		} catch(FileNotFoundException e) {}
		
		numCows = in.nextInt();
		cows = new int[numCows];
		//System.out.println(numCows);
		for(int i = 0; i < numCows; i++) {
			in.nextInt();
			cows[i] = in.nextInt();
		}
		
		int min = cows[numCows-1];
		int count = numCows-1;
		int numThings = 0;
		System.out.println(cows[0]);
		while(count >= 0) {
			if(cows[count] > min) {
				
			}
				
			else {
				numThings++;
				min = cows[count];
			}
			count--;
		}
		
		
		System.out.print(numThings);
		out.print(numThings );
		out.close();
		
	}
}
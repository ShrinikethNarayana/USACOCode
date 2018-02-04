import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays
public class Angry {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
		
	public static void main(String[] args) {
		Angry bat = new Angry();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("angry.in");	
			in = new Scanner(into);	
			out = new PrintWriter("angry.out");
		} catch(FileNotFoundException e) {}
		
		
		int numBale = in.nextInt();
		int numCow = in.nextInt();
		int[] bales = new int[numBale];
		for(int i = 0; i < numBale; i++) {
			bales[i] = i.nextInt();
		}
		
		if (numBale == 1)
			answer = 0;
		Arrays.sort(bales);
		int[] difs = new int[numBale-1]
		int[] numDestr = new int[numBale-1];
		for(int i = 0; i < numBale-1; i++) {
			difs[i] = bales[i+1] - bales[i];
			difs2[i] = bales[i+1] - bales[i];
		}
		
		//Arrays.sort(difs);
		int answer = 0;
		int tempAns = 0;
		int numSkip = 0;
		for (int i: difs) {
			if(numSkip == numCow-1)
				answer = (answer+1)/2;
			tempAns += i
		}
			
			
		
		out.print(answer);
		out.close();
	}
	
}
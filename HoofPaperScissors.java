import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
public class HoofPaperScissors {
	
	public static void main(String[] args) {
		HoofPaperScissors hps = new HoofPaperScissors();
		hps.run();
	}
	
	public void run() {
		File into = null;	
		Scanner in = null;	
		PrintWriter out = null;
		
		try {
			into = new File("hps.in");	
			in = new Scanner(into);	
			out = new PrintWriter("hps.out");
		} catch(FileNotFoundException e) {
			
			
		}
		
		
		int numTimes = in.nextInt();
		int[][] results = new int[2][numTimes];
		for(int i = 0; i < numTimes; i++) {
			
			results[0][i] = in.nextInt();
			results[1][i] = in.nextInt();
		}
		
		
		int result1 = 0;
		for(int i = 0; i < numTimes; i++) {
			if(results[0][i] == results[1][i])
				;
			else if(results[0][i] == 1 && results[1][i] == 3)
				result1++;
			else if(results[0][i] == 2&& results[1][i] == 1)
				result1++;
			else if(results[0][i] == 3&& results[1][i] == 2)
				result1++;
		}
		
		int result2 = 0;
		for(int i = 0; i < numTimes; i++) {
			if(results[0][i] == results[1][i])
				;
			else if(results[0][i] == 1 && results[1][i] == 2)
				result2++;
			else if(results[0][i] == 2&& results[1][i] == 3)
				result2++;
			else if(results[0][i] == 3&& results[1][i] == 1)
				result2++;
		}
		
		out.print(Math.max(result1, result2));
		out.close();
	}
}
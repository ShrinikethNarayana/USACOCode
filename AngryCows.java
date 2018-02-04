import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Marathon {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int[][] points;
	int numPoint;
	public static void main(String[] args) {
		Marathon bat = new Marathon();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("marathon.in");	
			in = new Scanner(into);	
			out = new PrintWriter("marathon.out");
		} catch(FileNotFoundException e) {}
		
		numPoint = in.nextInt();
		points = new int[numPoint][2];
		for(int i = 0; i < numPoint; i++) {
			
			
		}
		
		///System.out.print(numThings);
		out.print(dist-most );
		out.close();
		
	}
}
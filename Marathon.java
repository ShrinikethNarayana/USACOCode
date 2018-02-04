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
			
			points[i][0] = in.nextInt();
			points[i][1] = in.nextInt();
			
		}
		
		int dist = 0;
		for(int i = 0; i < numPoint-1; i++) {
			dist += (int)(Math.abs(points[i][0]-points[i+1][0]) + Math.abs(points[i][1]-points[i+1][1]));
		}
		
		int most = 0;
		
		for(int i = 1; i < numPoint-1; i++) {
			int regular = Math.abs(points[i-1][0]-points[i][0]) + Math.abs(points[i-1][1]-points[i][1]) + Math.abs(points[i][0]-points[i+1][0]) + Math.abs(points[i][1]-points[i+1][1]);
			int reduced = Math.abs(points[i-1][0]-points[i+1][0]) + Math.abs(points[i-1][1] - points[i+1][1]);
			if(regular - reduced > most)
				most = regular-reduced;
		}
		
		///System.out.print(numThings);
		out.print(dist-most );
		out.close();
		
	}
}
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
public class CrossRoad {
	int numCross;
	String word;
	File into;	
	Scanner in;	
	PrintWriter out;
		
	public static void main(String[] args) {
		CrossRoad bat = new CrossRoad();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("crossroad.in");	
			in = new Scanner(into);	
			out = new PrintWriter("crossroad.out");
		} catch(FileNotFoundException e) {}
		
		int[] cowPos = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		
		numCross = in.nextInt();
		int crossings = 0;
		int cow;
		for(int a = 0; a < numCross; a++) {
			cow = in.nextInt();
			if(cowPos[cow-1] == -1)
				cowPos[cow-1] = in.nextInt();
			else {
				int tempPos = in.nextInt();
				if(cowPos[cow-1] != tempPos) {
					crossings++;
					cowPos[cow-1] = tempPos;
				}
			}
		}
		out.print(crossings);
		out.close();
	}
}
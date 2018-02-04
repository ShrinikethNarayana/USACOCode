import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
public class CircleCross {
	int numCross;
	File into;	
	Scanner in;	
	PrintWriter out;
	int count = 0;
	String positions;
		
	public static void main(String[] args) {
		CircleCross bat = new CircleCross();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("circlecross.in");	
			in = new Scanner(into);	
			out = new PrintWriter("circlecross.out");
		} catch(FileNotFoundException e) {}
		
		int[] cowPos = {};
		positions = in.nextLine();

		for(int i = 0 + (int)'A'; i < 26+(int)'A'; i++) {
			for(int j = i+1; j < 26+(int)'A'; j++) {
				findCross(i, j);
			}
			
		}
		
		out.print(count);
		out.close();
	}
	
	public void findCross(int a, int b) {
		char i = (char)(a);
		char j = (char)(b);
		int initial = positions.indexOf(i);
		boolean inside = false;
		initial++;
		while(initial < 52) {
			if(!inside && positions.charAt(initial) == j) {
				inside = !inside;
			}
			else if(inside && positions.charAt(initial) == j)
				return;
			else if(positions.charAt(initial) == i) {
				if(count < 10)
				System.out.println(i + " " + j);
				if(inside)
					count++;
				return;
			}
			initial++;
		}
		
	}
}

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
public class CircleCross2 {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int[] cowStart;
	int[] cowEnd;
	int numCow;
	
	public static void main(String[] args) {
		CircleCross2 bat = new CircleCross2();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("circlecross.in");	 
			in = new Scanner(into);	
			out = new PrintWriter("circlecross.out");
		} catch(FileNotFoundException e) {}
		
		numCow = in.nextInt();
		
		HashSet<Integer> cows = new HashSet<Integer>();
		
		for(int i = 0; i < numCow*2; i++) {
			Integer temp = in.nextInt();
			if(cows.contains(temp)) {
				cows.remove();
			}
			
			
			
		}
		
	}
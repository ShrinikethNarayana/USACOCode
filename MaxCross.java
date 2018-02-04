import java.util.*;
import java.io.*;
public class MaxCross {
	
	int numCross;
	File into;	
	Scanner in;	
	PrintWriter out;
	int needed;
	int numBroke;
	boolean[] lights;
	
	public static void main(String[] args) {
		MaxCross bat = new MaxCross();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("maxcross.in");	
			in = new Scanner(into);	
			out = new PrintWriter("maxcross.out");
		} catch(FileNotFoundException e) {}
		
		
		numCross = in.nextInt();
		needed = in.nextInt();
		numBroke = in.nextInt();
		lights = new boolean[numCross];
		
		for(int i = 0; i < numBroke; i++) {
			int j = in.nextInt();
			lights[j-1] = true; 
		}
		//Arrays.sort(array);
		
		int min = 100000;
		for(int i = 0; i < numCross-needed+1; i++) {
			int temp = 0;
			if(( i > 0 && lights[i] != lights[i-1]) || i == 0) {
				for(int j = i; j < i+needed; j++) {
					if(lights[j]) 
						temp++;
				}
				if(temp < min)
					min = temp;
			}
		}
		
		
		out.print(min);
		out.close();
	}
}
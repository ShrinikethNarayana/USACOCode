
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Islands {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int[] cows;
	int numCows;
	public static void main(String[] args) {
		Islands bat = new Islands();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("islands.in");	
			in = new Scanner(into);	
			out = new PrintWriter("islands.out");
		} catch(FileNotFoundException e) {}
		
		int numBar = in.nextInt();
		
		Bar[] bars = new Bar[numBar];
		int[] bars2 = new int[numBar];
		for(int i = 0; i < numBar; i++) {
			int temp = in.nextInt();
			bars[i] = new Bar(i, temp);
			bars2[i] = temp;
		}
		
		Arrays.sort(bars);
		int islands = 1;
		int max = 1;
		boolean start = false;
		int left = 0;
		int right = 0;
		
		
		for(Bar b: bars) {
			if ((b.pos != 0 && bars2[b.pos-1] > b.height) && (b.pos != numBar-1 && bars2[b.pos+1] > b.height)) {
				islands++;
			}
			else if ((b.pos != 0 && bars2[b.pos-1] < b.height) && (b.pos != numBar-1 && bars2[b.pos+1] < b.height)) {
				islands--;
			}
			else if((b.pos == 0 || bars2[b.pos-1] == b.height) || (b.pos == numBar-1 || bars2[b.pos+1] == b.height)) {
				if(!start) {
					if(b.pos != 0)
						left = bars2[b.pos-1];
					start = true;
				}
				else if(b.pos == numBar-1 || bars2[b.pos+1] != b.height) {
					if(b.pos != numBar-1 )
						right = bars2[b.pos+1];
					
					if(left > b.height && right > b.height)
						islands++;
					else if((right == 0 && left < b.height) || (left == numBar-1 && right < b.height))
						islands--;
					else if(right == 0 && left == numBar-1)
						islands = 1;
					else if(left < b.height && right < b.height)
						islands--;
					start = false;
				}
			}
			if(islands > max)
				max = islands;
		}
		
		System.out.println(max);
		out.print(max-1);
		
	}
	
	public class Bar implements Comparable {
		int pos;
		int height;
		
		public Bar(int p, int h)  {
			pos = p;
			height = h;
		}
		
		public int compareTo(Object other) {
			if (height-((Bar) other).height != 0)
				return height-((Bar)other).height;
			else
				return pos-((Bar)other).pos;
		}
	}
}
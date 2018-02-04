import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Reorder {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int[] cowStart;
	int[] cowEnd;
	int numCow;
	public static void main(String[] args) {
		Reorder bat = new Reorder();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("reorder.in");	
			in = new Scanner(into);	
			out = new PrintWriter("reorder.out");
		} catch(FileNotFoundException e) {}
		
		numCow = in.nextInt();
		cowStart = new int[numCow];
		cowEnd = new int[numCow];
		
		for(int i = 0; i < numCow; i++) {
			cowStart[i] = in.nextInt()-1;
		}
		
		for(int i = 0; i < numCow; i++) {
			cowEnd[in.nextInt()-1] = i;
		}
		
		int len = 0;
		int numShift = 0;
		for(int i = 0; i < numCow; i++) {
		//	System.out.println(i +  "  " + cowEnd[i]);
			System.out.println(i +  "  " + cowStart[i]);
		}
		for(int i = 0; i < numCow; i++) {
			if(cowEnd[cowStart[i]] != i) {
				int empty = i;			 //empty space
				int temp2 = cowStart[i]; //held value
				int temp = -1;			 //for swapping held value
				int pos = i;
				numShift++;
				int tempLen = 0;
				
				//System.out.println("cyclic shift from: " + empty + " of value: " + temp2);
				do {
					int dest = cowEnd[temp2]; //where temp2 is supposed to be
					System.out.println("putting "+temp2+" in location "+dest+"; storing "+cowStart[dest]);
					//System.out.println(dest);
					temp = cowStart[dest];    	//value at destination
					cowStart[dest] = temp2;		//set value at destination to temp2
					//System.out.println(temp);
					temp2 = temp;				//set new stored value that was replaced by temp 1
					tempLen++;
					
				} while(cowEnd[temp] != empty);
				
				tempLen++;
				if(tempLen > len)
					len = tempLen;
				cowStart[empty] = temp;
				for(int a = 0; a < numCow; a++) {
					System.out.println(a +  "  " + cowStart[a]);
				}
				
			}
			
		}
		System.out.println( numShift + " " + len);
		///out.print();
		//out.close();
		
	}
}
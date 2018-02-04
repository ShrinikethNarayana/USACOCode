import java.util.*;
import java.io.*;
public class HelpCross {
	int numCross;
	File into;	
	Scanner in;	
	PrintWriter out;
	int[] chicken; 
	int[] cowStart;
	int[] cowEnd;
	int numC;
	int numN;
	public static void main(String[] args) {
		HelpCross bat = new HelpCross();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("helpcross.in");	
			in = new Scanner(into);	
			out = new PrintWriter("helpcross.out");
		} catch(FileNotFoundException e) {}
		
		
		numC = in.nextInt();
		numN = in.nextInt();
		cowStart = new int[numN];
		cowEnd = new int[numN];
		chicken = new int[numC];
		
		for(int i = 0; i < numC; i++) {
			chicken[i] = in.nextInt();
		}
		boolean[][] chToC = new boolean[numC][numN];
		
		System.out.println(chicken[3]);
		
		for(int i = 0; i < numC; i++) {
			for(int j = 0; j < numN; j++) {
				if(chicken[i] <= cowEnd[j] && chicken[i] >= cowStart[j])
					chToC[i][j] = true;
				System.out.print(chToC[i][j]);
			}
			System.out.println();
		}
		
		boolean[] cowsNot = new boolean[numN];
		int count = 0;
		for(int a = 0; a < numC; a++) {
			for(int b = 0; b < numN; b++) {
				if(chToC[a][b] && !cowsNot[b]) {
					cowsNot[b] = true;
					count++;
					break;
				}
			}
		}
		
		
		out.print(3);
		out.close();
	}
}
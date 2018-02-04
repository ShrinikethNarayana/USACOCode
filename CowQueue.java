import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
public class CowQueue {
	int numCross;
	File into;	
	Scanner in;	
	PrintWriter out;
	int count = 0;
	String positions;
		
	public static void main(String[] args) {
		CowQueue bat = new CowQueue();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("cowqueue.in");	
			in = new Scanner(into);	
			out = new PrintWriter("cowqueue.out");
		} catch(FileNotFoundException e) {}
		
		int n = in.nextInt();
		int[] arrive = new int[n];
		int[] time = new int[n];
		
		for(int a = 0; a < n; a++) {
			int temp3 = in.nextInt();
			arrive[a] = temp3; 
			time[a] = in.nextInt(); 
		}
		
		int least = 1000000;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-1; j++) {
				if(arrive[j] > arrive[j+1]) {
					int temp = arrive[j+1];
					int temp2 = time[j+1];
					arrive[j+1] = arrive[j];
					arrive[j] = temp;
					time[j+1] = time[j];
					time[j] = temp2;
					System.out.println("swapped "+arrive[i]+" and "+ arrive[i+1]);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(arrive[i]+" , "+time[i]);
		}
		
		long whatTime = 0;
		for(int a = 0; a < n; a++) {
			System.out.println(a + " " + whatTime);
			if(whatTime < arrive[a])
				whatTime = arrive[a] + time[a];
			else 
				whatTime += time[a];
		}
		
		System.out.println(n-1 + " " + whatTime);
		
		out.print(whatTime);
		out.close();
	}
	
	
}
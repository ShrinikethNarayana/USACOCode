import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class div7memo {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int[] cows;
	int numCows;
	int[][] memo;
	public static void main(String[] args) {
		div7 bat = new div7();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("div7.in");	
			in = new Scanner(into);	
			out = new PrintWriter("div7.out");
		} catch(FileNotFoundException e) {}
		
		
		numCows = in.nextInt();
		memo = new int[numCows][numCows];
		cows = new int[numCows];
		for(int i = 0; i < numCows; i++)
			cows[i] = in.nextInt()%7;
		
		int group = 0;
		int ans = 0;
		int sum = 0;
		for(int i: cows)
			sum += i;
		sum %= 7;
		if(sum == 0)
			ans = numCows;
		
		ans = ends(0, numCows-1, sum);
		System.out.println(ans);
		
		out.println(ans);
		out.close();
		
		
	}
	
	
	public int ends(int start, int end, int sum) {
		if (start == end)
			return 0;
		
		if(sum%7 == 0) {
			memo[start][end] = end-start+1;
			return end-start+1;
		}
		if(memo[start][end] != 0)
			return memo[start][end];
		int ans1 = ends(start+1, end, (sum-cows[start])%7);
		int ans2 = ends(start, end-1, (sum-cows[start])%7);
		
		memo[start][end] = Math.max(ans1, ans2);
		return memo[start][end];
		
	}
}
		
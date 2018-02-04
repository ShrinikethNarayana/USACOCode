import java.util.*;
import java.io.*;
public class Haybales {
	int numCross;
	File into;	
	Scanner in;	
	PrintWriter out;
	int count = 0;
	String positions;
	int[] array; 
	
	public static void main(String[] args) {
		Haybales bat = new Haybales();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("haybales.in");	
			in = new Scanner(into);	
			out = new PrintWriter("haybales.out");
		} catch(FileNotFoundException e) {}
		
		array = new int[in.nextInt()];
		int q = in.nextInt();
		
		for(int i = 0; i < array.length; i++) {
			array[i] = in.nextInt();
		}
		Arrays.sort(array);
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		for(int a = 0; a < q; a++) {
			int min = in.nextInt();
			int max = in.nextInt();
			int temp1 = find(0, array.length-1, min);
			int temp2 = find(0, array.length-1, max);
			if(array[temp1] < min)
				temp1++;
			if(array[temp2] <= max)
				temp2++;
			out.println(temp2-temp1);
		}
		
		//out.print(count);
		out.close();
	}
	
	public int find(int min, int max, int query) {
		int search = (min+max)/2;
		if(array[search] == query)
			return search;
		else {
			if(min == max)
				return min;
			else if(array[search] < query)
				return find(min, search-1, query);
			else
				return find(search+1, max, query);
			
		}
	}
	
/*	public void findInBetween(int index, int begin, int end) {
		if(array[index] < begin)
			index++;
		int temp = -1000;
		int sum = 0;
		while(temp < end && index < array.length) {
			
			temp = array[index];
			System.out.println(temp);
			index++;
			if(temp < end)
				sum++;
		}
		out.println(sum);
	} */
}
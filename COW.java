import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
public class COW {
	long cows;
	long size;
	String word;
	File into;	
	Scanner in;	
	PrintWriter out;
		
	public static void main(String[] args) {
		COW bat = new COW();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("cow.in");	
			in = new Scanner(into);	
			out = new PrintWriter("cow.out");
		} catch(FileNotFoundException e) {}
		
		cows = 0;
		size = in.nextInt();
		in.nextLine();
		word = in.nextLine();
		into = null;
		
		System.out.println(word);
		for(int a = 0; a < size; a++) {
			if(word.charAt(a) == 'C')
				cows += getO(a);
		}
		
		out.print(cows);
		out.close();
	}
	
	public long getO(int index) {
		long count = 0;
		for(int a = index; a < size; a++) {
			if(word.charAt(a) == 'O')
				count += getW(a);
		}
		return count;
	}
	
	public long getW(int index) {		
		long count = 0;
		for(int a = index; a < size; a++) {
			if(word.charAt(a) == 'W')
				count++;
		}
		return count;
	}
}
/*
TASK: gift1
LANG: JAVA
*/
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
public class Gift1 {
	File into;	
	Scanner in;	
	PrintWriter out;
		
	public static void main(String[] args) {
		Gift1 bat = new Gift1();
		bat.run();
	}
		
	public void run() {
		try {
			into = new File("gift1.in");	
			in = new Scanner(into);	
			out = new PrintWriter("gift1.out");
		} catch(FileNotFoundException e) {}
		
		int friends = in.nextInt();
		String[] friend = new String[friends];
		HashMap money = new HashMap(friends);
		for(int i = 0; i < friends; i++) {
			String next = in.next();
			money.put(next, 0);
			friend[i] = next;
		}
		
		while(in.hasNext()) {
			String name = in.next();
			int amount = in.nextInt();
			money.put(name, (Integer)money.get(name)+amount);
			int numGift = in.nextInt();
			for(int i = 0; i < numGift; i++) {
				String nam = in.next();
				money.put(nam, (Integer)money.get(nam)-amount/numGift);
			}
		}
		
		
		for(String frien: friend) {
			out.println(frien + " " + money.get(frien));
		}
		out.close();
	}
	
	
}
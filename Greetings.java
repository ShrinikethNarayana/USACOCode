import java.util.*;
import java.io.*;
public class Greetings {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int numBessie;
	int numElsie;
	
	public static void main(String[] args) {
		Greetings bat = new Greetings();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("greetings.in");	
			in = new Scanner(into);	
			out = new PrintWriter("greetings.out");
		} catch(FileNotFoundException e) {}
		
		numBessie = in.nextInt();
		numElsie = in.nextInt();
		
		int[] bessie = new int[numBessie];
		int[] elsie = new int[numElsie];
		String[] directionB = new String[numBessie]; 
		String[] directionE = new String[numElsie]; 
		
		
		int timeB = 0;
		int timeE = 0;
		
		for(int i = 0; i < numBessie; i++) {
			bessie[i] = in.nextInt();
			directionB[i] = in.next();
			timeB += bessie[i];
		}
		
		for(int i = 0; i < numElsie; i++) {
			elsie[i] = in.nextInt();
			directionE[i] = in.next();
			timeE += elsie[i];
		}
		
		if(timeB > timeE)
			timeE = timeB;
		else
			timeB = timeE;
		
		int[] dirB = new int[timeB];
		int[] dirE = new int[timeE];
		//makes boolean array of going left/right directions instead of many directions
		int countPos = 0;
		for(int i = 0; i < numBessie; i++) {
			if(directionB[i].equals("L")) {
				for(int j = countPos; j < countPos + bessie[i]; j++) {
					dirB[j] = 1;
				}			
			}
			if(directionB[i].equals("R")) {
				for(int j = countPos; j < countPos + bessie[i]; j++) {
					dirB[j] = -1;
				}			
			}
			countPos += bessie[i];
		}
		
		countPos = 0;
		for(int i = 0; i < numElsie; i++) {
			if(directionE[i].equals("L")) {
				for(int j = countPos; j < countPos + elsie[i]; j++) {
					dirE[j] = 1;
				}			
			}
			if(directionE[i].equals("R")) {
				for(int j = countPos; j < countPos + elsie[i]; j++) {
					dirE[j] = -1;
				}			
			}
			countPos += elsie[i];
		}
		
		int posB = 0;
		int posE = 0;
		//whether bessie and elsie are already together, not moving same direction
		boolean together = true;
		int greet = 0;
		
		for(int i = 0; i < timeB; i++) {
			
			posB += dirB[i];
			posE += dirE[i];
			
			if(posB == posE) {
				if(!together) {
					greet++;
					System.out.println("A moo at time " + i + " and at position " + posB + " " + posE);
				}
				
				together = true;	
			}
			else
				together = false;
		}
		
		out.print(greet);
		out.close();
	}
}
import java.util.*;
import java.io.*;
public class Blink {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int numLight;
	long totalTime;
	
	public static void main(String[] args) {
		Blink bat = new Blink();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("blink.in");	
			in = new Scanner(into);	
			out = new PrintWriter("blink.out");
		} catch(FileNotFoundException e) {}
	
		numLight = in.nextInt();
		totalTime = in.nextLong();
		
		boolean[] lights = new boolean[numLight];
		
		for(int i = 0; i < numLight; i++) {
			lights[i] = in.nextInt() != 0;
		}
		
		HashMap<String, Integer> occurrence = new HashMap<>();
		String tempLights = Arrays.toString(lights);
		
		
			
		occurrence.put(tempLights, 0);
		
		
		
		
		
		int time = 1;
		while(time <= totalTime) {
			lights = change(lights);
			tempLights = Arrays.toString(lights);
			
			if(occurrence.containsKey(tempLights)) {
				break;
			}
			else
				occurrence.put(tempLights, time);
			time++;
		}
		
		System.out.println(time + "  " + totalTime);
		
		if(time == totalTime+1) {
			for(int i = 0; i < numLight; i++) {
				out.println(lights[i] ? 1: 0);
				//System.out.println(lights[i] ? 1: 0);
			}
			
			out.close();
			return;
		}
		
		
		long loopTime = time - occurrence.get(tempLights);
		long timeLeft = (totalTime-occurrence.get(tempLights)) % loopTime;
	
		
		for(int i = 0; i < timeLeft; i++) {
			lights = change(lights);
		}
		
		for(int i = 0; i < numLight; i++)
			out.println(lights[i] ? 1: 0);
		
		out.close();
	}
	
	
	
	public boolean[] change(boolean[] lights) {
		boolean[] newLights = new boolean[lights.length];
		for(int i = 0; i < lights.length; i++) {
			if(lights[i]){
				if(i != lights.length-1)
					newLights[i+1] = !lights[i+1];
				
				else
					newLights[0] = !lights[0];
			}
			else if(i != lights.length-1)
				newLights[i+1] = lights[i+1];
			else
				newLights[0] = lights[0];
			
		}
		System.out.println("\n\nNext: ");
		for(int i = 0; i < numLight; i++) {
					System.out.println(newLights[i] ? 1: 0);
			}
		return newLights;                              
		
	}
}
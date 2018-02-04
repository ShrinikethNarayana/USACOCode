import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.*;
import java.io.*;
public class Measurement {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	int numLogs;
	public static void main(String[] args) {
		Measurement bat = new Measurement();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("measurement.in");	
			in = new Scanner(into);	
			out = new PrintWriter("measurement.out");
		} catch(FileNotFoundException e) {}
		
		numLogs = in.nextInt();
		in.nextInt();
		
		
		int[][] logs = new int[numLogs][3];
		
		for(int i = 0; i < numLogs; i++) {
			logs[i][0] = in.nextInt();
			logs[i][1] = in.nextInt();
			logs[i][2] = in.nextInt();
		}
		
		HashMap<Integer, Integer> cows = new HashMap<Integer, Integer>();
		HashMap<Integer, Boolean> isDayChanged = new HashMap<Integer, Boolean>();
		HashSet<Integer> bestCows = new HashSet<Integer>();
		int maxMilk = 0;
		
		Comparator<int[]> c = (int[] a, int[] b) ->  a[0]-b[0];
		
		Arrays.sort(logs, c);
		System.out.println(logs[0][0]);
		
		int day = 0;
		//int changeCount = 0;
		//boolean willChange = false;
		for(int i = 0; i < numLogs; i++) {
			//System.out.println(logs[i][0]);
			//System.out.println(isDayChanged.get(logs[i][0]));
			
			if(isDayChanged.get(logs[i][0]) == null)
				isDayChanged.put(logs[i][0], false);
			Integer cowId = logs[i][1];
			int change = logs[i][2];
			int initial = 0;
			if(!cows.containsKey(cowId))
				cows.put(cowId, change);
			else {
				initial = cows.get(cowId);
				cows.put(cowId, initial+change);
			}
			
			if(!bestCows.contains(cowId)) {
				if(cows.get(cowId) > maxMilk) {
					bestCows.clear();
					if(maxMilk != 0)
						bestCows.add(cowId);
					isDayChanged.put(logs[i][0], true);
					System.out.print("day set to changed: " + cowId + " " + maxMilk);
					for(int cow: bestCows) 
						System.out.print(cow);
					System.out.println();
					maxMilk = cows.get(cowId);
				}
				else if(cows.get(cowId) == maxMilk){
					isDayChanged.put(logs[i][0], true);
					System.out.print("day set to changed: " + cowId + " " + maxMilk);
					for(int cow: bestCows) 
						System.out.print(cow);
					System.out.println();
					if(maxMilk != 0)
						bestCows.add(cowId);
				}
			}
			
			else{
				if (cows.get(cowId) < maxMilk){
					bestCows.remove(cowId);
					isDayChanged.put(logs[i][0], true);
					System.out.print("day set to changed: " + cowId);
					for(int cow: bestCows) 
						System.out.print(cow);
					System.out.println();
					//check if bestCows is empty
					if(bestCows.size() == 0) {
						int newMax = 0;
						int newCow = -1;
						for(int cid : cows.keySet()){
							if (cows.get(cid) > newMax){
								newMax = cows.get(cid);
								newCow = cid;
							}
						}
						if(newMax != 0)
							bestCows.add(newCow);
					}
					
				}
				else if(cows.get(cowId) > maxMilk) {
					bestCows.clear();
					bestCows.add(cowId);
					isDayChanged.put(logs[i][0], true);
					
					maxMilk = cows.get(cowId);
					System.out.print("day set to changed: shouldwork" + cowId + " " + maxMilk);
				}
			}
			
			
			/*
			if(cows.get(cowId) > maxMilk) {
				if(day != logs[i][0])
				changeCount++;
				maxMilk = cows.get(cowId);
			}
			else if(initial == maxMilk && logs[i][0] != day)
				changeCount++;
			
			if(day != logs[i][0])
				day = logs[i][0];
			*/
			
		}
		
		int count = 0;
		for(boolean is: isDayChanged.values())
			if(is)
				count++;
			
		out.print(count);
		out.close();
	}
	
	
}
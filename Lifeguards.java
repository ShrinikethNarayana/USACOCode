import java.util.*;
import java.io.*;
public class Lifeguards {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	int numCows;
	int[][] lifeguards;
	public static void main(String[] args) {
		Lifeguards bat = new Lifeguards();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("lifeguards.in");	
			in = new Scanner(into);	
			out = new PrintWriter("lifeguards.out");
		} catch(FileNotFoundException e) {}
		
		numCows = in.nextInt();
		lifeguards = new int[numCows][2];
		
		for(int i = 0; i < numCows; i++) {
			lifeguards[i][0] = in.nextInt();
			lifeguards[i][1] = in.nextInt();
		}
		
		Arrays.sort(lifeguards, new Comparator<int[]>() {
			public int compare(final int[] entry1, final int[] entry2) {
				int i = entry1[0]-entry2[0];
				if(i == 0)
					i = entry1[1]-entry2[1];
			 return i;
			 }
		});
		
		//System.out.println(findWorst());
		
		int index = findWorst();
		
		//lifeguards[index][1] = lifeguards[index][0];
		
		int sum = 0;
		int ind = 0;
		/*while(ind < numCows) {
			int start = lifeguards[ind][0];
			int max = lifeguards[ind][1];
			ind++;
			while(true) {
				if(lifeguards[ind][0] >= start && lifeguards[ind][1] > max)
					max = lifeguards[ind+1][1];
				else if
					break;
				
			}
			
		}*/
		int cend = lifeguards[0][0];
		if(index == 0)
			cend = lifeguards[1][0];
		for(int i = 0; i < numCows; i++) {
			if(i == index)
				continue;
			int start = lifeguards[i][0];
			int max = lifeguards[i][1];
			if(max > cend) {
				sum += max-Math.max(start, cend);
				cend = max;
			}
		}
		
		
		out.print(sum);
		out.close();
		
		
		
	}
	
	public int findWorst() {
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		for (int i = 0; i < numCows; i++) {
			int[] invComp = lifeguards[i]; 
			int[] tempInv = new int[]{invComp[0], invComp[1]};
			int prevStart = 0;
			boolean hasStarted = false;
			for (int j = prevStart; j < numCows; j++) {
				int[] inv = lifeguards[j];
				if(inv[1] < tempInv[0]){
					continue;
				}else if(!hasStarted){
					hasStarted = true;
					prevStart = j;
				}
				
				if(inv == invComp)
					continue;
				if(inv[0] > tempInv[1])
					break;
				
				if(invComp[0] < inv[0] && invComp[1] > inv[1]){
				//	System.out.println("full interval overlap! "+i+","+j);
					return j;
				}
				
				int[] overlap = new int[]{Math.max(tempInv[0], inv[0]), Math.min(tempInv[1], inv[1])};
				if(overlap[0] == tempInv[0])
					tempInv[0] = overlap[1];
				else
					tempInv[1] = overlap[0];
				
				if(tempInv[1] - tempInv[0] <= 0){
			//		System.out.println("interval length <= 0! "+i+","+j);
					return i;
				}
				
			}
			hasStarted = false;
			
			//System.out.println("Index "+i+": "+(tempInv[1] - tempInv[0]));
			map.put(1*(tempInv[1] - tempInv[0]), i);
			
		}
		
		return map.lowerEntry(map.lastKey()).getValue();
		
		//return 0;
	}
	
	
}
import java.util.*;
import java.io.*;
public class Mootube {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	int numVids;
	
	public static void main(String[] args) {
		Mootube bat = new Mootube();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("mootube.in");	
			in = new Scanner(into);	
			out = new PrintWriter("mootube.out");
		} catch(FileNotFoundException e) {}
		
		numVids = in.nextInt();
		int numQuery = in.nextInt();
		
		
		Map[] graph1 = new Map[numVids];

        for(int i = 0; i < numVids; i++) {
            graph1[i] = new HashMap<Integer, Integer>();
        }
		
	/*	Map[] graph2 = new Map[numField];

        for(int i = 0; i < numField; i++) {
            graph2[i] = new HashMap<Integer, Integer>();
        }
		
		*/
		for(int i = 0; i < numVids-1; i++) {
			int a = in.nextInt()-1; 
			int b = in.nextInt()-1; 
			int c = in.nextInt(); 
			graph1[a].put(b, c);
			graph1[b].put(a, c);
		}
		
		for(int i = 0; i < numQuery; i++) {
			int k = in.nextInt();
			int node = in.nextInt()-1;
			
			boolean[] traversed = new boolean[numVids];
			
			LinkedList q = new LinkedList<Integer>();
			q.add(node);
			
			int count = -1;
			while(q.peek() != null) {
				node = (int)(q.poll());
				traversed[node] = true;
				count++;
				for(Object j: graph1[node].keySet()) {
					int m = (Integer)j;
					if(traversed[m] == false && (int)graph1[node].get(m) >= k) {
						q.add(m);
					}
				}
			}
			out.println(count);
		}
		out.close();
		
		
		
	}
	
	
}
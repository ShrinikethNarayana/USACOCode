import java.util.*;
import java.io.*;

public class CowRouting{

	static Map<Integer, Integer>[] graph;
    static int numFlight;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("cowroute.in"));

		int start = in.nextInt()-1;
		int end = in.nextInt()-1;
        numFlight = in.nextInt();
		int[] prevPath = new int[1000];
        graph = new Map[1000];

        for(int i = 0; i < 1000; i++) {
            graph[i] = new HashMap<Integer, Integer>();
        }

        while(in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
			int[] c = new int[b];
			System.out.print("Cities ");
			for(int i = 0; i < b; i++) {
				c[i] = in.nextInt()-1;
				System.out.print(c[i] + " ");
			}
			System.out.println();
			for(int i = b-1; i > 0; i--) {
				for(int j = 0; j < i; j++) {
					graph[c[j]].put(new Integer(c[i]), new Integer(a));
				///	System.out.println("Node " + (c[j]+1) + " is going to " + (c[i]+1) + "with cost " + a);
				}
			}
			

        }
		

        CowRouting rb = new CowRouting();

		int ans = rb.dijkstra(start, end, prevPath);
		
		int node2 = end;
        int ans2 = 0;
		if(ans == -1)
			ans2 = -1;
		else {
			while(node2 != start ) {
				int prev = prevPath[node2];
				
				node2 = prev;
			}
			ans2+=2;
		}
        PrintWriter out = new PrintWriter(new File("cowroute.out"));
        out.print(ans + " " + ans2);
        out.close();
        in.close();
    }

	public int dijkstra (int s, int d, int[] prevPath) {
        int minDist[] = new int[1000];
        for(int i = 0; i < 1000; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        minDist[s] = 0;

        Comparator<Integer> c = (Integer a, Integer b) ->  minDist[a.intValue()] - minDist[b.intValue()];

		
		Arrays.fill(prevPath, -1);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(1000, c);
        queue.add(s);

        while(queue.size() > 0) {
            int node = queue.poll();
            if(node == d)
                return minDist[d];
            for(Integer neigh: graph[node].keySet()) {
                int neighbor = neigh.intValue();
                int weight = graph[node].get(neighbor);

                if(weight + minDist[node] < minDist[neighbor]) {
                    minDist[neighbor] = weight + minDist[node];
                    queue.remove(neighbor);
                    queue.add(neighbor);
					prevPath[neighbor] = node;
                }

            }
        }
        return  -1;
    }
	
}
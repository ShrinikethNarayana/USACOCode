import java.util.*;
import java.io.*;

public class RoadBlock{

    static Map<Integer, Integer>[] graph;
    static int numField;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("rblock.in"));


        numField = in.nextInt();
        int[] prevPath = new int[numField];
        //int[][] paths = new int[numField][numField];
        int dest = in.nextInt()-1;
        graph = new Map[numField];

        for(int i = 0; i < numField; i++) {
            graph[i] = new HashMap<Integer, Integer>();
        }

        while(in.hasNext()) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            int c = in.nextInt();

			//if(a < b)
				graph[a].put(new Integer(b), new Integer(c));
           // else
				graph[b].put(new Integer(a), new Integer(c));

        }

        RoadBlock rb = new RoadBlock();

		
        int first = rb.dijkstra(0, numField-1, prevPath);
        System.out.println(numField-1 + " " + prevPath.length);
        /**int node2 = numField-1;
        int best = 0;
        int best2 = -1;
        while(prevPath[node2] != 0 ) {
            graph[prevPath[node2]].put(node2, graph[prevPath[node2]].get(node2)*2);
			graph[node2].put(prevPath[node2], graph[prevPath[node2]].get(node2));
            int temp = rb.dijkstra(0, numField-1, prevPath);
            if ( temp > best) {
                best = temp;
            }
            graph[prevPath[node2]].put(node2, graph[prevPath[node2]].get(node2)/2);
			graph[node2].put(prevPath[node2], graph[prevPath[node2]].get(node2));
            node2 = prevPath[node2];
        } **/
		 int node2 = prevPath.length-1;
        int best = first;
        while(node2 != 0 ) {
            int prev = prevPath[node2];
            int weight = graph[prev].get(node2);
            graph[prev].put(node2, weight *2);
            graph[node2].put(prev, weight*2);
            int temp = rb.dijkstra(0, numField-1, prevPath);
            if ( temp > best) {
                best = temp;
            }
            graph[prev].put(node2, weight);
            graph[node2].put(prev, weight);
            node2 = prev;
        }

        PrintWriter out = new PrintWriter(new File("rblock.out"));
        out.print(best-first);
        out.close();
        in.close();
    }


    public int dijkstra (int s, int d, int[] prevPath) {
        int minDist[] = new int[numField];
        for(int i = 0; i < numField; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        minDist[s] = 0;
       // Comparator<Integer> c = (Integer a, Integer b) -> {
       //     return minDist[a - 1] - minDist[b - 1];
       // };

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
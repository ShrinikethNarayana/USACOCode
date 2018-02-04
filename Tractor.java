
public class Tractor {
	File into;	
	Scanner in;	
	PrintWriter out;
	public static void main(String[] args) {
		
		try {
			into = new File("tractor.in");	
			in = new Scanner(into);	
			out = new PrintWriter("tractor.out");
		} catch(FileNotFoundException e) {}
		
		Tractor tr = new Tractor();
		tr.run()
	}
		
	public void run() {
		
		
		
		//Dijkstra's algorithm code taken from http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
		Foreach node set distance[node] = HIGH
		SettledNodes = empty
		UnSettledNodes = empty

		Add sourceNode to UnSettledNodes
		distance[sourceNode]= 0

		while (UnSettledNodes is not empty) {
			evaluationNode = getNodeWithLowestDistance(UnSettledNodes)
			remove evaluationNode from UnSettledNodes
			add evaluationNode to SettledNodes
			evaluatedNeighbors(evaluationNode)
		}

		getNodeWithLowestDistance(UnSettledNodes){
			find the node with the lowest distance in UnSettledNodes and return it
		}

		evaluatedNeighbors(evaluationNode){
			Foreach destinationNode which can be reached via an edge from evaluationNode AND which is not in SettledNodes {
				edgeDistance = getDistance(edge(evaluationNode, destinationNode))
				newDistance = distance[evaluationNode] + edgeDistance
				if (distance[destinationNode]  > newDistance ) {
					distance[destinationNode]  = newDistance
					add destinationNode to UnSettledNodes
				}
			}
		}
			
	}
	
	public void makeGraph() {
		
		
		
	}
	
	
}

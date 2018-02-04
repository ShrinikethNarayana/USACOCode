import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.*;
import java.io.*;
public class Homework {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	
	int numProb;
	public static void main(String[] args) {
		Homework bat = new Homework();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("homework.in");	
			in = new Scanner(into);	
			out = new PrintWriter("homework.out");
		} catch(FileNotFoundException e) {}
		
		numProb = in.nextInt();
		//PriorityQueue<Integer> queue = new PriorityQueue<Integer>(numProb);
		Integer[] problems = new Integer[numProb];  //sorted array
		int[] problems2 = new int[numProb]; //unsorted array
		
		for(int i = 0; i < numProb; i++) {
			problems[i] = in.nextInt();
			problems2[i] = problems[i];
			//queue.add(problems[i]);
		}
		
		
		//int minNumCount = 0; //the counter for which index of problems2 is the real minimum number as some of them will be deleted as it goes by.
		int numEat = 1; //the number of homeworks bessie ate
		ArrayList<Integer> bestRem = new ArrayList<Integer>(numProb);
		int sumScore = 0;
		for(int ele: problems) {
			sumScore -= ele;
		}
		queue.remove(problems[0]);
		//sumScore += problems2[queue.peek()];
		
		int best = (sumScore+queue.peek())/(numProb-numEat-1);
		bestRem.add(new Integer(1));
		int contender = 0;
		for(int i = 1; i < numProb-2; i++) {
			sumScore += problems[i];
			
			queue.remove(problems[i]);
			System.out.println(numProb-i-2);
			contender = (sumScore+queue.peek())/(numProb-i-2);
			
			if(contender >= best) {
				if(contender > best)
					bestRem.clear();
				best = contender;
				bestRem.add(new Integer(i+1));
			}
				
		}
		for(Integer ele: bestRem)
			out.print(ele.intValue());
		out.close();
	}
	
	
}
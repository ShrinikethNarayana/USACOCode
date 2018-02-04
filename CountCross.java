import java.util.*;
import java.io.*;
public class CountCross {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	int gridSize = 0;
	int numCows;
	int[][] roads;
	int[][] cows;
	boolean[][] roadBlocks2;
	boolean[][] roadBlocks;
	int numRoads;
	boolean[][] passed;
	public static void main(String[] args) {
		CountCross bat = new CountCross();
		bat.run();
	}
		
	public void run() {
		
		
		try {
			into = new File("countcross.in");	
			in = new Scanner(into);	
			out = new PrintWriter("countcross.out");
		} catch(FileNotFoundException e) {}
		
		
		gridSize = in.nextInt();
		numCows = in.nextInt();
		numRoads = in.nextInt();
		roads = new int[numRoads][4];
		
		
		for(int i = 0; i < numRoads; i++) {
			roads[i][0] = in.nextInt()-1;
			roads[i][1] = in.nextInt()-1;
			roads[i][2] = in.nextInt()-1;
			roads[i][3] = in.nextInt()-1;
		}
		
		cows = new int[numCows][2];
		for(int i = 0; i < numCows; i++) {
			cows[i][0] = in.nextInt();
			cows[i][1] = in.nextInt();
		}
		
		
		//up/down
		roadBlocks = new boolean[gridSize-1][gridSize];
		//side tto side
		roadBlocks2 = new boolean[gridSize][gridSize-1];
		
		for(int a = 0; a < numRoads; a++) {
			if(roads[a][0] == roads[a][2]-1) 
				roadBlocks[roads[a][0]][roads[a][1]] = true;
			if(roads[a][0] == roads[a][2]+1)
				roadBlocks[roads[a][2]][roads[a][1]] = true;
			if(roads[a][1] == roads[a][3]-1)
				roadBlocks2[roads[a][0]][roads[a][1]] = true;
			if(roads[a][1] == roads[a][3]+1)
				roadBlocks2[roads[a][0]][roads[a][3]] = true;
		}
		
		/*for(int a = 0; a < gridSize; a++) {
			for(int b = 0; b < gridSize; b++) {
				
				if(a != gridSize-1)
					System.out.print(roadBlocks[a][b]);
				if(b != gridSize-1)
					System.out.print(roadBlocks2[a][b]);
				System.out.println(a + " " + b);
			}
		}*/
		
		int counter = 0;
		
		for(int a = 0; a < numCows; a++) {
			for(int b = a+1; b < numCows; b++) {
				System.out.println("a and b" + a + " " + b);
				passed = new boolean[gridSize][gridSize];
				if(!findWay(cows[a][0]-1, cows[a][1]-1, cows[b][0]-1, cows[b][1]-1)) {
					counter++;
				//	System.out.println("a and b" + a + " " + b);
				}
			}
		}
		
		out.print(counter);
		out.close();
	}
	
	public boolean findWay(int x, int y, int getX, int getY) {
		System.out.println(x + " " + y);
		if(x == getX && y == getY)
			return true;
		
			passed[x][y] = true;
			if( getX > x && x+1 != gridSize && !roadBlocks[x][y] && !passed[x+1][y])
				if(findWay(x+1, y, getX, getY))
					return true;
			if( getX < x && x!= 0 && !roadBlocks[x-1][y]&& !passed[x-1][y])
				if(findWay(x-1, y, getX, getY))
					return true;
			if( getY > y&& y+1 != gridSize && !roadBlocks2[x][y]&& !passed[x][y+1])
				if(findWay(x, y+1, getX, getY))
					return true;
			if(getY <y && y!= 0 && !roadBlocks2[x][y-1]&& !passed[x][y-1])
				if(findWay(x, y-1, getX, getY))
					return true;
			
			if( getX <= x && x+1 != gridSize && !roadBlocks[x][y] && !passed[x+1][y])
				if(findWay(x+1, y, getX, getY))
					return true;
			if( getX >= x && x!= 0 && !roadBlocks[x-1][y]&& !passed[x-1][y])
				if(findWay(x-1, y, getX, getY))
					return true;
			if( getY <= y&& y+1 != gridSize && !roadBlocks2[x][y]&& !passed[x][y+1])
				if(findWay(x, y+1, getX, getY))
					return true;
			if(getY >= y&& y != 0 && !roadBlocks2[x][y-1]&& !passed[x][y-1])
				if(findWay(x, y-1, getX, getY))
					return true;
		
		return false;
	} 
	
	

}
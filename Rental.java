import java.util.*;
import java.io.*;
public class Rental {
	
	File into;	
	Scanner in;	
	PrintWriter out;
	

	
	public static void main(String[] args) {
		Rental bat = new Rental();
		bat.run();
	}
		
	public void run() {
		
		try {
			into = new File("rental.in");	
			in = new Scanner(into);	
			out = new PrintWriter("rental.out");
		} catch(FileNotFoundException e) {}
		
		int numCows = in.nextInt();
		int numStores = in.nextInt();
		int numFarms = in.nextInt();
		
		int[] cows = new int[numCows];
		for(int i = 0; i < numCows; i++) {
			cows[i] = in.nextInt();
			
		}
		Arrays.sort(cows);
		
		int[][] stores = new int[numStores][2];
		
		for(int i = 0; i < numStores; i++) {
			stores[i][0] = in.nextInt();
			stores[i][1] = in.nextInt();	
		}
		
		//comparator format code found online
		
		
		//Arrays.sort(stores, new CompArr() );
		//code for comparator sort from https://www.ktbyte.com/java-tutorial/java-cheat-sheets
		Arrays.sort(stores, new Comparator<int[]>() {
			public int compare(final int[] entry1, final int[] entry2) {
				int i = entry1[1]-entry2[1];
				if(i == 0)
					i = entry1[0]-entry2[0];
			 return i;
			 }
 });
		
		int[] farms2 = new int[numFarms];
		for(int i = 0; i < numFarms; i++) {
			farms2[i] = in.nextInt();
		}
		
	/*	Comparator c2 = new Comparator<Integer>() { 
			public int compareTo(Integer i, Integer j) {
				int k = j-i;
				return k;
			}
		};
		
		new Comparator<Integer[]>() { 
			public int compareTo(Integer[] i, Integer[] j) {
				int k = i[1]-j[1];
				if(k == 0)
					k = i[0]-j[0];
				return k;
			}
		}
		*/
		Arrays.sort(farms2);
		int[] farms = new int[numFarms];
		for(int i = 0; i < numFarms; i++) {
			farms[numFarms-1-i] = farms2[i];
		}
		
		
		int maxMilk = 0;
		for(int i: cows) {
			maxMilk+=i;
		}
		int milk = maxMilk;
		long money = 0;
		int count = numStores-1;
		while(milk > 0 && count >= 0) {
			int amount = stores[count][0]; 
			int value = stores[count][1];
			if(milk < amount) {
				money += value*milk;
				stores[count][0] = milk;
				milk = 0;
				break;
			}
			else {
				money += value*amount;
				milk -= amount;
				count--;
			}
		}
		if(count < 0)
			count = 0;
		//System.out.println(count + "  " + stores[count][1]);
		long maxMoney = 0;
		int countStore = count;
		int countRent = 0;
		while(maxMoney < money && countRent < numFarms && countStore < numStores) {
			maxMoney = money;
			if(milk >= cows[countRent]) {
				money += farms[countRent];
				milk -= cows[countRent];
				countRent++;
			}
			else {
				milk -= cows[countRent];
				money += farms[countRent];
				countRent++;
				
				while(milk < 0 && countStore < numStores) {
					//keep subtracting money from stores until milk deficit is depleted
					if(stores[countStore][0] > milk*-1) {
						stores[countStore][0] += milk; //subtract milk deficit from the store
						money += stores[countStore][1]*milk;
						milk = 0;
					}
					else if(stores[countStore][0] == milk*-1) {
						//stores[countStore][0] += milk; //subtract milk deficit from the store
						countStore++;
						money += stores[countStore][1]*milk;
						milk = 0;
					}
					else if(countStore < numStores){
						money -= stores[countStore][1]*stores[countStore][0];
						milk += stores[countStore][0];
						countStore++;
					}
				}
				
			}
			
		}
		
		
		out.print(maxMoney);
		out.close();
		
		
		
	}
	
	
}
/*

class CompArr implements Comparator<Integer[]>{
	@Override
	public int compare(Integer[] i, Integer[] j){
		int k = i[1]-j[1];
				if(k == 0)
					k = i[0]-j[0];
				return k;
	}
}*/
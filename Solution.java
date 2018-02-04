import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		Scanner sn = new Scanner(System.in);
		System.out.println(s.getPowerNum(sn.nextLong()));
	}
	public long getPowerNum(long index) {
		ArrayList<Long> powers = new ArrayList<Long>(999999);
		for(int i = 2; i < 1000; i++) {
			for(int j = 2; j < 60; j++) {
				long pows = (long)Math.pow(i, j);
				if(pows < 0)
					break;
				powers.add(pows);
			}
		}
		Collections.sort(powers);
		return powers.get((int)index);
	}
}
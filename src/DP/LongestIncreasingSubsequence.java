package DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/longest-increasing-subsequence/
 * Cannot figure out how to achieve it in O(nlogn)
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = {3, 10, 2, 1, 20};
		System.out.println(solveLIS(nums));
		List<Integer> res = constructLIS(nums);
		printLIS(res);
	}
	
	private static int solveLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	private static List<Integer> constructLIS(int[] nums) {
		List<List<Integer>> subsequences = new ArrayList<>();
		subsequences.add(new ArrayList<Integer>(Arrays.asList(nums[0])));
		for(int i = 1; i < nums.length; i++)
			subsequences.add(new ArrayList<Integer>());
		
		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && subsequences.get(j).size() > subsequences.get(i).size()) {
					subsequences.set(i, new ArrayList<Integer>(subsequences.get(j)));
				}
			}
			subsequences.get(i).add(nums[i]);
		}
		
		List<Integer> longestSubsequence = subsequences.get(0);
		for(List<Integer> l : subsequences) {
			if(l.size() > longestSubsequence.size()) {
				longestSubsequence = l;
			}
		}
		return longestSubsequence;
	}
	
	private static void printLIS(List<Integer> lis) {
		for(int num : lis)
			System.out.println(num);
	}
}

package DP;

public class LargestSumContiguousSubarray {
	public static void main(String[] args) {
		int a[] = {-2, -3, -4, -1, -2, -1, -5, -3};
		System.out.println(solveLSCS(a));
		int[] res = solveLSCS_position(a);
		System.out.println("The start index is " +  res[0]);
		System.out.println("The end index is " +  res[1]);
	}
	
	// max(nums[i], dp[i-1]+nums[i]), it only depends on one variable about what has traversed
	private static int solveLSCS(int[] nums) {
		int maxSum = nums[0], priorMaxSum = 0;
		for(int i = 1; i < nums.length; i++) {
			priorMaxSum = Math.max(priorMaxSum + nums[i], nums[i]);
			maxSum = Math.max(maxSum, priorMaxSum);
		}
		return maxSum;
	}
	
	private static int[] solveLSCS_position(int[] nums) {
		int maxSum = nums[0], end = 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			if(dp[i] > maxSum) {
				maxSum = dp[i];
				end = i;
			}	
		}
		int start = end;
		for(int i = end - 1; i >= 0; i--) {
			if(dp[i] < 0) {
				start = i + 1;
				break;
			}	
			if(i == 0)
				start = 0;
		}
		
		return new int[] {start, end};
	}
}

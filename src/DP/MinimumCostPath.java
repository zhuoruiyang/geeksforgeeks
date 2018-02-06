package DP;
/*
 * https://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * Written on Jan. 19th, 2018.
 */
public class MinimumCostPath {
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int[][] cost= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        System.out.println("minimum cost to reach (2, 2) = " +
        		minCostTopDown(cost, 2, 2));
    }
    
    private static int minCostBottomUp(int[][] cost, int m, int n) {
    	int rows = cost.length, cols = cost[0].length;
    	int[][] dp = new int[rows+1][cols+1];
    	for(int i = 1; i < rows+1; i++) {
    		for(int j = 1; j < cols+1; j++) {
    			int minOffset = 0;
    			if(i - 1 == 0 && j - 1 == 0) 
    				minOffset = 0;
    			else if(i - 1 == 0)
    				minOffset = dp[i][j-1];
    			else if(j - 1 == 0)
    				minOffset = dp[i-1][j];
    			else
    				minOffset = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
    			dp[i][j] = cost[i-1][j-1] + minOffset;
    		}
    	}
    	return dp[m+1][n+1];
    }
    
    private static int minCostTopDown(int[][] cost, int m, int n) {
    	int rows = cost.length, cols = cost[0].length;
    	int[][] dp = new int[rows+1][cols+1];
    	minCostRecursive(cost, dp, rows, cols);
    	return dp[m+1][n+1];
    }
    
    private static int minCostRecursive(int[][] cost, int[][] dp, int m, int n) {
    	if(m == 0 || n == 0)
    		return 0;
    	if(dp[m][n] > 0)
    		return dp[m][n];
    	
    	int minOffset = 0;
    	if(m - 1 == 0 && n - 1 == 0)
    		minOffset = 0;
    	else if(m - 1 == 0)
    		minOffset = minCostRecursive(cost, dp, m, n-1);
    	else if(n - 1 == 0)
    		minOffset = minCostRecursive(cost, dp, m-1, n);
    	else
    		minOffset = Math.min(Math.min(minCostRecursive(cost, dp, m-1, n-1), minCostRecursive(cost, dp, m-1, n)), 
    				minCostRecursive(cost, dp, m, n-1));

    	dp[m][n] = cost[m-1][n-1] + minOffset;

    	return dp[m][n];
    }
}

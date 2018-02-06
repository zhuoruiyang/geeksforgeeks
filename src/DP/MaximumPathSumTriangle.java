package DP;
/*
 * https://www.geeksforgeeks.org/maximum-path-sum-triangle/
 */
public class MaximumPathSumTriangle {
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int[][] triangle= {{1, 0, 0},
                       {4, 8, 0},
                       {1, 5, 3}};
        System.out.println("maximum path sum = " +
        		maxPathSum(triangle));
    }
    
    private static int maxPathSum(int[][] triangle) {
    	int m = triangle.length, n = triangle[0].length;
    	for(int i = m-2; i >= 0; i--) {
    		for(int j = 0; j < n; j++) {
    			if(triangle[i][j] > 0)
    				triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
    		}
    	}
    	return triangle[0][0];
    }
}

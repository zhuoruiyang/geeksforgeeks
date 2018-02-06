package DP;
/*
 * https://www.geeksforgeeks.org/longest-repeated-subsequence/
 */
public class LongestReapeatedSubsequence {
	public static void main(String[] args) {
		String input = "AABEBCDD";
		System.out.println(solveLRS(input));
		System.out.println(printLRS(input));
	}
	
	public static int solveLRS(String s) {
		int[][] dp = new int[2][s.length()+1];
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < s.length(); j++) {
				int r = i & 1;
				if(i != j && s.charAt(i) == s.charAt(j)) {
					dp[r][j+1] = dp[1-r][j] + 1;
				}
				else {
					dp[r][j+1] = dp[r][j] > dp[1-r][j+1] ? dp[r][j] : dp[1-r][j+1];
				}
			}
		}
		return dp[1][s.length()];
	}
	
	public static String printLRS(String s) {
		int[][] dp = new int[s.length()+1][s.length()+1];
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < s.length(); j++) {
				if(i != j && s.charAt(i) == s.charAt(j)) {
					dp[i+1][j+1] = dp[i][j] + 1;
				}
				else {
					dp[i+1][j+1] = dp[i+1][j] > dp[i][j+1] ? dp[i+1][j] : dp[i][j+1];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int m = s.length(), n = m;
		while(m >= 1 && n >= 1) {
			if(m != n && s.charAt(m-1) == s.charAt(n-1)) {
				sb.append(s.charAt(m-1));
				m--;
				n--;
			}
			else {
				if(dp[m-1][n] > dp[m][n-1]) {
					m--;
				}
				else {
					n--;
				}
			}
		}
		return sb.reverse().toString();
	}
}

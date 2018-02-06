package DP;

public class LongestCommonSubstring {
	public static void main(String[] args) {
		String X = "OldSite:GeeksforGeeks.org";
		String Y = "NewSite:GeeksQuiz.com";
		System.out.println(solveLCS(X, Y));
	}
	
	
	// have a question why use two variables won't work?
	private static int solveLCS(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		int result = 0;
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					if(i >= 1 && j >= 1 && s1.charAt(i-1) == s2.charAt(j-1)) {
						dp[i+1][j+1] = dp[i][j] + 1;
					}
					else {
						dp[i+1][j+1] = 1;
					}
				}
				else {
					dp[i+1][j+1] = 0;
				}
				result = Math.max(result, dp[i+1][j+1]);
			}
		}
		return result;
	}
	
}

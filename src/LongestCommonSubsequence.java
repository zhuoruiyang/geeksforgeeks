/*
 * https://www.geeksforgeeks.org/longest-common-subsequence/ 
 * https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * 1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:
L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)
 * 2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be written as:
L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )
 */
public class LongestCommonSubsequence {
	public static void main(String[] args) {
	    String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
//	    s1 = "ABCDGH";
//	    s2 = "AEDFHR";
	    int res = solveLCS(s1, s2);
	    System.out.println(res);
	    System.out.println(printLCS(s1, s2));
	    System.out.println(solveLCS_optimized(s1, s2));
	}
	
	public static int solveLCS(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j))
					dp[i+1][j+1] = dp[i][j] + 1;
				else
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
			}
		}
		return dp[s1.length()][s2.length()];
	}
	
	public static String printLCS(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j))
					dp[i+1][j+1] = dp[i][j] + 1;
				else
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int m = s1.length(), n = s2.length();

		while(m >= 1 && n >= 1) {
			if(s1.charAt(m-1) == s2.charAt(n-1)) {
				sb.append(s1.charAt(m-1));
				m--;
				n--;
			}
			else {
				if(dp[m][n-1] > dp[m-1][n]) 
					n--;
				else 
					m--;
			}
		}
		
		return sb.reverse().toString();
	}
	
	// Optimize the space, reducing it from O(m*n) to O(2*n)
	public static int solveLCS_optimized(String s1, String s2) {
		int[][] dp = new int[2][s2.length()+1];
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				int r = i & 1;
				if(s1.charAt(i) == s2.charAt(j)) {
					dp[r][j+1] = dp[1-r][j] + 1;
				}
				else {
					dp[r][j+1] = dp[r][j] > dp[1-r][j+1] ? dp[r][j] : dp[1-r][j+1];
				}
			}
		}
		return dp[1][s2.length()];
	}
}

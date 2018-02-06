package DP;

public class LCS3Strings {
	public static void main(String[] args) {
	    String X = "AGGT12";
	    String Y = "12TXAYB";
	    String Z = "12XBA";
	    X = "abcd1e2"; 
	    Y = "bc12ea";  
	    Z = "bd1ea";
	    System.out.println(solveLCS3Strings(X, Y, Z));
	}

	private static int solveLCS3Strings(String s1, String s2, String s3) {
		int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				for(int k = 0; k < s3.length(); k++) {
					if(s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k)) {
						dp[i+1][j+1][k+1]  = dp[i][j][k] + 1;
					}
					else {
						// fix one dimension and move another two
						int v1 = Math.max(dp[i][j+1][k+1], dp[i+1][j][k+1]);
						int v2 = Math.max(dp[i+1][j][k+1], dp[i+1][j+1][k]);
						dp[i+1][j+1][k+1] = Math.max(v1, v2);
					}
				}
			}
		}
		return dp[s1.length()][s2.length()][s3.length()];
	}
}


public class LongestReapeatedSubsequence {
	public static void main(String[] args) {
		String s = solveLRS("aaabbb");
		System.out.println(s);
	}
	
	public static String solveLRS(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < i; j++) {
				if(s.charAt(i) == s.charAt(j) && i != j)
					sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}

import java.util.*

class CountOfPalindromicSubsequence {
	public static void main(String[] args) {
	    CountOfPalindromicSubsequence m = new CountOfPalindromicSubsequence();
	    String s = "abdbca";
	    int[][] dp = new int[s.length()][s.length()];
	    for (int i=0; i<s.length(); i++)
	        for (int j=0; j<s.length(); j++)
	            dp[i][j] = -1;
            System.out.println(m.longestSequence(s, 0, s.length()-1, dp));
	}
    
    public int longestSequence(String s, int start, int end, int[][] dp) {
        if (start == end)
            return 1;
        if (start > end)
            return 0;
        if (dp[start][end] == -1) {
            if (s.charAt(start) == s.charAt(end)) {
                int remainingLength = end - start - 1;
                if (remainingLength == longestSequence(s, start+1, end-1, dp)) {
                    return remainingLength+2;
                }
            }
            int l1 = longestSequence(s, start+1, end, dp);
            int l2 = longestSequence(s, start, end-1, dp);
            dp[start][end] = Math.max(l1, l2);
        }
        return dp[start][end];
    }
}

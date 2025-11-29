class Solution {
    public boolean isMatch(String s, String p) {
        // dp[i][j] means s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true; // empty string == empty pattern

        // handle patterns like a*, a*b*, a*b*c*
        for (int j = 1; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {

                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {

                    // zero occurrence of previous char
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];

                    // one or more occurrences
                    if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
                        dp[i + 1][j + 1] |= dp[i][j + 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}

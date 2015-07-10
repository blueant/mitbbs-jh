package org.blueant.linkedin;

/**
 * Author: Leon, created at: 05/12/2015, 5:27 PM.
 */

public class MaxLenPalindromicSubSequence {
  public class Solution {
    public int maxLengthPalindrome(int[] values) {
      if (values == null || values.length == 0) return 0;
      int len = values.length;
      int[] rev = getReverseArray(values);
      int[][] dp = new int[len + 1][len + 1];
      for (int i = 1; i <= len; i++) {
        for (int j = 1; j <= len; j++) {
          if (values[i - 1] == rev[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
          else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
      return dp[len][len];
    }

    private int[] getReverseArray(int[] v) {
      int[] res = new int[v.length];
      for (int i = 0; i < v.length; i++)
        res[i] = v[v.length - i - 1];
      return res;
    }
  }

  public static void main(String[] args) {
    new MaxLenPalindromicSubSequence().new Solution().maxLengthPalindrome(new int[]{4, 1, 2, 3, 4, 5, 6, 5, 4, 3, 4, 4, 4, 4, 4, 4, 4});
  }
}

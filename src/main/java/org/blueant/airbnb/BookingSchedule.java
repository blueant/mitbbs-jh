package org.blueant.airbnb;

/**
 * Author: Leon, created at: 05/14/2015, 11:27 AM.
 * Dmitry Alexeenko, https://www.linkedin.com/in/dalexeenko
 */

/*
给你一个list of airbnb booking schedule 比如一个array [4,6,8,3,8]，
既然是schedule保证所有的elements都是positive的然后让你求max sum with no consecutive elements
就是你用了4 就不能用6但是可以用8 3 8， 中间可以跳过more than one element 比如哦2 1 1 4 你应该return 6
 */
public class BookingSchedule {
  public int maxBookingValue(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int[] dp = new int[prices.length + 1];
    for (int i = 1; i <= prices.length; i++) {
      dp[i] = i == 1 ? prices[i - 1] : Math.max(dp[i - 1], prices[i - 1] + dp[i - 2]);
    }
    return dp[prices.length];
  }

  public int maxminumNights(int[] nights) {
    if (nights == null || nights.length == 0) return 0;
    int len = nights.length;
    int[] dp = new int[len + 1];
    for (int i=1; i <=len; i++) {
      dp[i] = i == 1 ? nights[0] : Math.max(dp[i-1], dp[i-2] + nights[i-1]);
    }

    return dp[len];
  }

  public int maxminumNights2(int[] nights) {
    if (nights == null || nights.length == 0) return 0;
    int len = nights.length;
    int prev2 = 0, prev1 = nights[0];
    for (int i=2; i <=len; i++) {
      int tmp = Math.max(prev1, prev2 + nights[i-1]);
      prev2 = prev1;
      prev1 = tmp;
    }

    return prev1;
  }

  public int maxNight(int[] a) {
    if(a == null || a.length == 0) return 0;
    else if (a.length == 1) return a[0];
    return backtracking(a, 1, a[0], 0);
  }

  public int backtracking(int[] a, int pos, int prev1, int prev2) {
    if (pos == a.length) return prev1;
    return backtracking (a, pos + 1, Math.max(a[pos] + prev2, prev1), prev1);
  }

  public static void main(String[] args) {
    System.out.println(new BookingSchedule().maxminumNights2(new int[]{5, 1, 2, 6, 20, 2}));
    System.out.println(new BookingSchedule().maxNight(new int[]{4, 6, 8, 3, 8}));
    System.out.println(new BookingSchedule().maxNight(new int[]{2, 1, 1, 3, 5, 4}));
  }
}

package org.blueant.linkedin;

/**
 * Author: Leon, created at: 04/29/2015, 11:08 PM.
 */

public class GameCanWin {
  private boolean canIWin(int maxChoosableInteger, int desiredTotal) {
//    if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
    boolean[] visited = new boolean[maxChoosableInteger + 1];
    return otherCanWin(maxChoosableInteger, visited, 0, desiredTotal);
  }

  private boolean otherCanWin(int n, boolean[] visited, int curSum, int desiredTotal) {
    if (curSum >= desiredTotal) return false;
    else {
      for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
          visited[i] = true;
          boolean isOtherWin = otherCanWin(n, visited, curSum + i, desiredTotal);
          visited[i] = false;
          if (!isOtherWin) return true;
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    GameCanWin game = new GameCanWin();
    for (int i = 16; i <= 120; i++) {
      if (!game.canIWin(15, i)) {
        System.out.println(i + " other will win!");
      }
    }
  }
}
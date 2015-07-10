package org.blueant.linkedin;

/**
 * Author: Leon, created at: 05/12/2015, 5:52 PM.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This is the interface that represents nested lists. You should not implement
 * it, or speculate about its implementation.
 */
interface NestedInteger {
  /**
   * @return true if this NestedInteger holds a single integer, rather than a nested list
   */
  boolean isInteger();

  /**
   * @return the single integer that this NestedInteger holds, if it holds a
   * single integer Return null if this NestedInteger holds a nested list
   */
  Integer getInteger();

  /**
   * @return the nested list that this NestedInteger holds, if it holds a nested list Return null if this NestedInteger holds a single
   * integer
   */
  List<NestedInteger> getList();
}

public class MyNestedIneteger implements NestedInteger {
  private Integer theSingleInteger;
  private List<NestedInteger> theList;

  public MyNestedIneteger(Integer theSingleInteger, List<NestedInteger> theList) {
    this.theSingleInteger = theSingleInteger;
    this.theList = theList;
  }

  @Override
  public boolean isInteger() {
    return null == theList && null != theSingleInteger;
  }

  @Override
  public Integer getInteger() {
    return theSingleInteger;
  }

  @Override
  public List<NestedInteger> getList() {
    return theList;
  }

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();
    string.append("{");
    if (null != theSingleInteger) {
      string.append(theSingleInteger);
    }
    if (null != theList) {
      for (NestedInteger current : theList) {
        string.append(", ").append(current.toString());
      }
    }
    string.append("}");
    return string.toString();
  }

  public static class Solution {
    public int depthSum(List<NestedInteger> input) {
      return depthSumHelper(input, 1);
    }

    private int depthSumHelper(List<NestedInteger> input, int depth) {
      int sum = 0;
      for (NestedInteger i : input) {
        if (i.isInteger()) sum += depth * i.getInteger();
        else {
          sum += depthSumHelper(i.getList(), depth + 1);
        }
      }
      return sum;
    }
  }


  public static void main(String[] args) {
    List<NestedInteger> lst = new ArrayList<>();
    List<NestedInteger> tmp = new ArrayList<>();
    tmp.add(new MyNestedIneteger(1, null));
    tmp.add(new MyNestedIneteger(1, null));
    lst.add(new MyNestedIneteger(0, tmp));
    lst.add(new MyNestedIneteger(2, null));
    tmp = new ArrayList<>();
    tmp.add(new MyNestedIneteger(1, null));
    tmp.add(new MyNestedIneteger(1, null));
    lst.add(new MyNestedIneteger(0, tmp));
    System.out.println(new Solution().depthSum(lst));
  }
}

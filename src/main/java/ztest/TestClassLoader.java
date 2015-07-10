package ztest;

/**
 * Author: Leon, created at: 05/15/2015, 1:25 AM.
 */

public class TestClassLoader {
  static {
    System.out.println("Static block executed!");
  }

  public static void main(String args[]) throws Exception {
    System.out.println("hello");
//    Class.forName("TestClassLoader", true, TestClassLoader.class.getClassLoader());
  }
}

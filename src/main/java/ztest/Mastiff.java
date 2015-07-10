package ztest;

/**
 * Author: Leon, created at: 05/15/2015, 1:30 AM.
 */

/**
 * 子类藏獒
 */
public class Mastiff extends Dog {
  public Mastiff() {
    System.out.println("Mastiff");
  }

  {
    System.out.println("block");
  }

  static {
    System.out.println("static block");
  }

  public static void main(String[] args) {
    System.out.println("hello");
    Mastiff mastiff = new Mastiff();

  }
}

package ztest.classloader;

/**
 * Author: Leon, created at: 05/15/2015, 1:32 AM.
 */

class Parent {
  public static String p_StaticField = "父类--静态变量";
  public String p_Field = "父类--变量";

  static {
    System.out.println(p_StaticField);
    System.out.println("父类--静态初始化块");
  }

  {
    System.out.println(p_Field);
    System.out.println("父类--初始化块");
  }

  public Parent() {
    System.out.println("父类--构造器");
  }
}

public class SubClass extends Parent {
  public static String s_StaticField = "子类--静态变量";
  public String s_Field = "子类--变量";

  static {
    System.out.println(s_StaticField);
    System.out.println("子类--静态初始化块");
  }

  {
    System.out.println(s_Field);
    System.out.println("子类--初始化块");
  }

  public SubClass() {
    System.out.println("子类--构造器");
  }

  public static void main(String[] args) {
    new SubClass();
  }
}
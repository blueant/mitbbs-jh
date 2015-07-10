package ztest.classloader;

/**
 * Author: Leon, created at: 05/15/2015, 7:43 AM.
 */

public class TestStaticCon {
  public static int a = 0;
  static {
    a = 10;
    System.out.println("父类的非静态代码块在执行a=" + a);
  }
  {
    a = 8;
    System.out.println("父类的非静态代码块在执行a=" + a);
  }
  public TestStaticCon() {
    System.out.println("hello");
//    this("a在父类带参构造方法中的值：" + TestStaticCon.a); // 调用另外一个构造方法
//    System.out.println(a);
//    System.out.println("父类无参构造方法在执行a=" + a);
  }
  public TestStaticCon(String n) {
    System.out.println(n);
    System.out.println(a);
  }
  public static void main(String[] args) {
    TestStaticCon tsc = null;
    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
    tsc = new TestStaticCon();
  }
}
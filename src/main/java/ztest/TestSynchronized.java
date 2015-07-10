package ztest;

/**
 * Author: Leon, created at: 05/14/2015, 11:28 PM.
 */

public class TestSynchronized {
  public static class TestClass {
    public synchronized void fun1() {
      for (int i = 0; i < 10; i++) {
        try {
          Thread.sleep(1000L);
          System.out.println("hello from fun1: " + i);
        } catch (InterruptedException ignore) {
        }
      }
    }

    public  void fun2() {
      for (int i = 0; i < 10; i++) {
        try {
          Thread.sleep(1000L);
          System.out.println("hello from fun2: " + i);
        } catch (InterruptedException ignore) {
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    final TestClass c = new TestClass();
    new Thread(new Runnable() {
      @Override
      public void run() {
        c.fun1();
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        c.fun2();
      }
    }).start();

    Class.forName("hello", true, TestSynchronized.class.getClassLoader());
  }
}

package ztest;

import java.util.concurrent.Semaphore;

/**
 * Author: Leon, created at: 05/12/2015, 7:12 AM.
 */

public class MyClass {
  private ThreadLocal<String> local = new ThreadLocal<String>() {
    @Override
    protected String initialValue() {
      return "This is the initial value";
    }
  };

  public synchronized static void log1(String msg1, String msg2) {
    Semaphore s = new Semaphore(3);
    try {
      s.acquire();
    } catch (InterruptedException ignore) {
    } finally{
      s.release();
      s.release(100343);
    }

  }


  public static void log2(String msg1, String msg2) {
    synchronized (MyClass.class) {
    }
  }

  public void set(String v) {
    local.set(v);
  }
}

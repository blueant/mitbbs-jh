package ztest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Leon, created at: 05/12/2015, 2:06 PM.
 */

interface BlockingQueue<E> {
  void put(E e) throws InterruptedException;
  E take() throws InterruptedException;
}

public class BlockingQueueImpl<E> implements BlockingQueue<E> {
  private final ReentrantLock lock = new ReentrantLock(true);
  private final Condition notEmpty = lock.newCondition();
  private final Condition notFull = lock.newCondition();
  private int capacity;
  private final Deque<E> queue = new LinkedList<>();

  public BlockingQueueImpl(int capacity) {
    this.capacity = capacity;
  }

  @Override
  public void put(E e) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (queue.size() == capacity)
        notFull.await();
      queue.addLast(e);
      notEmpty.signalAll();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public E take() throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (queue.isEmpty()) notEmpty.await();
      E element = queue.removeFirst();
      notFull.signalAll();
      return element;
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(3);
    PriorityBlockingQueue<String> que = new PriorityBlockingQueue<>(3);
  }
}

package org.blueant.linkedin;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Leon, created at: 04/29/2015, 11:06 PM.
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
      notEmpty.signal();
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
      notFull.signal();
      return element;
    } finally {
      lock.unlock();
    }
  }
}


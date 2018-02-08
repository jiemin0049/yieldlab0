package com.yieldlab;

import java.util.LinkedList;

import com.yieldlab.util.BoundedBlockingQueue;

public class YieldlabQueue implements BoundedBlockingQueue {

  private static int DEFAULT_CAPACITY = 10;
  private int capacity;

  private final LinkedList<Object> queue = new LinkedList<>();

  public YieldlabQueue() {
    this(DEFAULT_CAPACITY);
  }

  public YieldlabQueue(int capacity) {
    this.capacity = capacity;
  }

  @Override
  public void put(Object element) throws InterruptedException {
    synchronized (this) {
      while (queue.size() >= capacity) {
        System.out.println("full queue");
        wait();
      }
      queue.add(element);
      System.out.println(Thread.currentThread().getName() + " adds '" + element + "', " + queue.size() + " in queue");
      notifyAll();
    }
  }

  @Override
  public Object get() throws InterruptedException {
    synchronized (this) {
      while (queue.size() == 0) {
        System.out.println("empty queue");
        wait();
      }

      Object e = queue.remove();
      System.out.println(Thread.currentThread().getName() + " get " + e + ", " + queue.size() + " in queue");
      notifyAll();
      return e;
    }
  }

  public int size() {
    return queue.size();
  }
}

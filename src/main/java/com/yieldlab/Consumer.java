package com.yieldlab;

public class Consumer implements Runnable {

  private YieldlabQueue queue;

  public Consumer(YieldlabQueue yieldlabQueue) {
    queue = yieldlabQueue;
  }

  @Override
  public void run() {
    try {
      queue.get();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

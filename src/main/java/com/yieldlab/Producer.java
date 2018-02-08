package com.yieldlab;

public class Producer implements Runnable {

  private YieldlabQueue queue;
  private Object obj;

  public Producer(YieldlabQueue yieldlabQueue, Object object) {
    queue = yieldlabQueue;
    obj = object;
  }

  @Override
  public void run() {
    try {
      queue.put(obj);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

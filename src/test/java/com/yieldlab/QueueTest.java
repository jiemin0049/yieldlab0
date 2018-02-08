package com.yieldlab;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QueueTest {

  /**
   * 1. Add 9 elements in queue, let the queue to be full. 
   * 2. Check queue size == 9
   * 3. Add 2 elements more, queue should block. 
   * 4. Check queue size == 9 ? 
   * 5. Create 9 Consumers and get elements from queue. 
   * 6. After that there should left 2 elements in queue.
   * 
   * @throws InterruptedException
   */
  @Test
  public void blockFullQueue() throws InterruptedException {
    int capacity = 9;
    YieldlabQueue queue = new YieldlabQueue(capacity);

    // create producers
    List<Thread> producers = new ArrayList<>();
    for (int i = 0; i < capacity; i++) {
      String element = "P" + i;
      producers.add(new Thread(new Producer(queue, element), "Producer " + i));
    }

    for (Thread t : producers) {
      t.start();
    }
    
    Thread.sleep(1000);
    
    assertEquals(capacity, queue.size());

    // Add 2 more, queue should block.
    Thread p10 = new Thread(new Producer(queue, "P10"), "Producer 10");
    Thread p11 = new Thread(new Producer(queue, "P11"), "Producer 10");

    p10.start();
    p11.start();
    
    Thread.sleep(1000);

    assertEquals(capacity, queue.size());

    // Create consumers
    List<Thread> consumers = new ArrayList<>();
    for (int i = 0; i < capacity; i++) {
      consumers.add(new Thread(new Consumer(queue), "Consumer " + i));
    }

    for (Thread t : consumers) {
      t.start();
    }
    Thread.sleep(1000);

    assertEquals(2, queue.size());
  }

  /**
   * 1. Create 4 Consumers, they get elements from queue, the queue is empty and should block. Queue size is 0. 
   * 2. Put 2 elements in queue, then 2 consumers should get these 2 elements. The queue is also block, queue size is 0. 
   * 3. Put 4 elements in queue, ohter 2 consumers get 2 elements. Queue is not block, queue size is 2.
   * 
   * @throws InterruptedException
   */
  @Test
  public void blockEmptyQueue() throws InterruptedException {
    int capacity = 4;
    YieldlabQueue queue = new YieldlabQueue(capacity);

    // Create consumers
    List<Thread> consumers = new ArrayList<>();
    for (int i = 0; i < capacity; i++) {
      consumers.add(new Thread(new Consumer(queue), "Consumer " + i));
    }

    for (Thread t : consumers) {
      t.start();
    }
    Thread.sleep(1000);

    assertEquals(0, queue.size());

    // Put 2 elements in queue, queue should block also.
    Thread p5 = new Thread(new Producer(queue, "P5"), "Producer 5");
    Thread p6 = new Thread(new Producer(queue, "P6"), "Producer 6");

    p5.start();
    p6.start();
    Thread.sleep(1000);

    assertEquals(0, queue.size());

    // create producers
    List<Thread> producers = new ArrayList<>();
    for (int i = 0; i < capacity; i++) {
      String element = "P" + i;
      producers.add(new Thread(new Producer(queue, element), "Producer " + i));
    }

    for (Thread t : producers) {
      t.start();
    }
    Thread.sleep(1000);
    
    assertEquals(2, queue.size());
  }

}
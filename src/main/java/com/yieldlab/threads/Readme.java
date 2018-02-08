package com.yieldlab.threads;

/**
 * When to use Volatile variable in Java:
 * 1. You can use Volatile variable if you want to read and write long and double variable atomically. 
 *    long and double both are 64 bit data type and by default writing of long and double is not atomic and platform dependence.
 * 2. Read after write: it's guaranteed that all reader thread will see updated value of the volatile variable once write operation completed.
 *    volatile keyword in Java guarantees that value of the volatile variable will always be read from main memory and not from Thread's local cache.
 *
 *
 *
 * @author Zhang
 *
 */

public class Readme {

}

package com.yieldlab;

/*
 * Display Triangle as follow : BREAK DEMO. 
 * 
 * 1 
 * 2 3 
 * 4 5 6 
 * 7 8 9 10 
 * ... N
 * 
 */
public class Triangle {
  public static void main(String[] args) {
    int n = 15, c = 0;
    boolean p = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        if (c != n) {
          c++;
          System.out.print(c + " ");
        } else {
          p = false;
        }
      }
      if (p) {
        System.out.println();
      }
    }
  }
}

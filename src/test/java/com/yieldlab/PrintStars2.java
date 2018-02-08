package com.yieldlab;

/*
 *      *
 *     ***
 *    *****
 *     ***
 *      *
 *    
 *    
 * @author Zhang
 *
 */
public class PrintStars2 {
  public static void main(String[] args) {
    print(7);
  }

  private static void print(int size) {

    int up = size / 2 + 1;
    int down = size - up;

    for (int i = 0; i < up; i++) {
      int s = 2 * i + 1;
      int b = up - (i + 1);
      for (int q = 0; q < b; q++) {
        System.out.print(" ");
      }
      for (int q = 0; q < s; q++) {
        System.out.print("*");
      }
      System.out.println();
    }

    for (int i = 0; i < down; i++) {
      for (int j = 0; j < i + 1; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < 2 * (down - i) - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

}

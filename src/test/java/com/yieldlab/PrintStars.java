package com.yieldlab;

/**
 *      *
 *     ***
 *    *****
 *    
 *    
 * @author Zhang
 *
 */
public class PrintStars {
public static void main(String[] args) {
  int line = 3;
  String blank = " ";
  String star = "*";
  for (int i = 0; i < line; i++) {
    int s = 2 * i + 1;
    int b = line - (i + 1);
    for (int q = 0; q < b; q++) {
      System.out.print(blank);
    }
    for (int q = 0; q < s; q++) {
      System.out.print(star);
    }
    System.out.println();
  }
}

}

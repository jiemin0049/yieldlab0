package com.yieldlab;

import java.util.ArrayList;
import java.util.List;

/**
 * [2, 4, 1, 6, 5, 40, -1], find 2 integers from array so that x*y = 20
 * 
 * @author Zhang
 *
 */
public class Test1 {
  public static void main(String[] args) {
    int[] array = new int[] { 2, 4, 1, 6, 5, 40, -1 };
    List<Integer> l = find2(array);
    if (l.isEmpty()) {
      System.out.println("not found!");
    } else {
      System.out.println(l.get(0) + ", " + l.get(1));
    }
    
    System.out.println(Math.random() * 1);
  }

  /**
   * 2*4, 2*1, 2*6..
   * 4*1, 4*6, 4*5..
   * 
   * @param array
   * @return
   */
  private static List<Integer> find(int[] array) {
    List<Integer> l = new ArrayList<>();
    int length = array.length;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if (array[i] * array[j] == 20) {
          l.add(array[i]);
          l.add(array[j]);
          return l;
        }
      }
    }
    return l;
  }

  /**
   * [2, 4, 1, 6, 5, 40, -1]
   * Add 2 into a temp list (2).
   * Check 4 with those list, if there is integer * 4 = 20 return,
   * if not, add 4 in temp list (2, 4).
   * 
   * check 1 with temp list, if there is an integer * 1 = 20 return,
   * if not, add 1 in temp list (2,4,1)
   * 
   * ......
   * 
   * @param array
   * @return
   */
  private static List<Integer> find2(int[] array) {
    List<Integer> l = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    temp.add(array[0]);
    int length = array.length;
    for (int i = 1; i < length; i++) {
      int a = array[i];
      for (Integer t : temp) {
        if (a * t == 20) {
          l.add(a);
          l.add(t);
          return l;
        }
      }
      temp.add(a);
    }
    return l;
  }
}

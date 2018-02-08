package com.yieldlab;

public class StringReverse {
  public static void main(String[] args) {
    String a = "abc";
    System.out.println(stringReverse2(a));
  }

  private static String stringReverse(String string) {
    if (string == null || string.length() == 0) {
      return string;
    }
    return stringReverse(string.substring(1)) + string.charAt(0);
  }
  
  private static String stringReverse2(String string) {
    if (string == null || string.length() == 0) {
      return string;
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = string.length() - 1; i >= 0; i--) {
      sb.append(string.charAt(i));
    }
    return sb.toString();
  }
}

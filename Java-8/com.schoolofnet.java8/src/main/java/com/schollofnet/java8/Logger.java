package com.schollofnet.java8;

public class Logger {
  public static void log(String str) {
    String divisor = "-";
    while (divisor.length() < str.length() + 4) {
      divisor += "-";
    }

    System.out.println("\n" + divisor);
    System.out.println("  " + str);
    System.out.println(divisor + "\n");
  }
}

package com.schollofnet.java8;

@FunctionalInterface
public interface MyInterface {
  void print(String s);

  default void body() {
    System.out.println("This is my interface function body");
  }
}

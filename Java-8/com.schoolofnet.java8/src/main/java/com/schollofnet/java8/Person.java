package com.schollofnet.java8;

public class Person {
  private Integer id;
  private String name;

  public Person() {

  }

  public Person(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return this.id;
  }

  public static void say(String srt) {
    System.out.println("A new person is saying something..." + srt);
  }
}

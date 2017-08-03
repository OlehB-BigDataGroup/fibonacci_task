package com.privateapp.fibonacci.utils;

public class Preconditions {

  public static <T> T checkNotNull(T obj) {
    if (obj == null) throw new NullPointerException();
    return obj;
  }

  public static void checkArgument(boolean condition) {
    checkArgument(condition, null);
  }

  public static void checkArgument(boolean condition, String message) {
    if (condition) throw new IllegalArgumentException(message);
  }
}

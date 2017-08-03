package com.privateapp.fibonacci.utils;

import java.math.BigInteger;

import static com.privateapp.fibonacci.utils.Preconditions.checkArgument;

public class FibonacciUtils {

  public static final BigInteger ELEM_0 = BigInteger.ZERO;
  public static final BigInteger ELEM_1 = BigInteger.ONE;

  public static BigInteger getFibonacci(int n) {
    checkArgument(n < 0, "Element number should be non-negative");
    return getFibonacci(ELEM_0, ELEM_1, 0, n);
  }

  private static BigInteger getFibonacci(
      BigInteger currentVal,
      BigInteger nextVal,
      int currentPosition,
      int target) {
    return currentPosition != target
        ? getFibonacci(nextVal, currentVal.add(nextVal), ++currentPosition, target)
        : currentVal;
  }
}

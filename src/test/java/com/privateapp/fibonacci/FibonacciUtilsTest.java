package com.privateapp.fibonacci;

import com.privateapp.fibonacci.utils.FibonacciUtils;
import org.junit.Test;

public class FibonacciUtilsTest {

  @Test(expected = IllegalArgumentException.class)
  public void whenNegativeValuePassed_shouldThrowIllegalArgumentException() throws Exception {
    FibonacciUtils.getFibonacci(-1);
  }
}
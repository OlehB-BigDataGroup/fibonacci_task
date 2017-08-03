package com.privateapp.fibonacci;

import com.privateapp.fibonacci.utils.FibonacciUtils;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FibonacciUtilsCalculationTest {

  @Parameterized.Parameter(0)
  public int n;
  @Parameterized.Parameter(1)
  public BigInteger result;

  @Parameterized.Parameters
  public static Object[][] fibonacciTestSet() {
    return new Object[][] {
        {1, new BigInteger("1")},
        {100, new BigInteger("354224848179261915075")},
        {0, new BigInteger("0")},
        {57, new BigInteger("365435296162")},
        {29, new BigInteger("514229")}
    };
  }

  @Test
  public void whenNonNegativeElementPassed_shouldReturnCorrespondingFibonacci() throws Exception {
    assertThat(FibonacciUtils.getFibonacci(n), equalTo(result));
  }
}
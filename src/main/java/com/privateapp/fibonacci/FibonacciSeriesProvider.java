package com.privateapp.fibonacci;

import com.privateapp.fibonacci.utils.FibonacciUtils;
import java.math.BigInteger;

public class FibonacciSeriesProvider implements SeriesProvider {

  @Override public BigInteger getElement(int elementPosition) {
    return FibonacciUtils.getFibonacci(elementPosition);
  }
}

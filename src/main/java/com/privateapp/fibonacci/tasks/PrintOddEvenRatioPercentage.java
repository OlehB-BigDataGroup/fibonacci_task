package com.privateapp.fibonacci.tasks;

import com.privateapp.fibonacci.SeriesProvider;
import java.math.BigInteger;

public class PrintOddEvenRatioPercentage extends SeriesTask {

  @Override public String perform(SeriesProvider provider, int element) {
    int oddCount = 0;
    int evenCount = 0;
    for (int i = 0; i <= element; i++) {
      if (isEven(provider.getElement(i))) {
        evenCount++;
      } else {
        oddCount++;
      }
    }
    return formResult(evenCount, oddCount);
  }

  @Override public String getTaskName() {
    return "Print all element up to entered";
  }

  private String formResult(int evenCount, int oddCount) {
    int sum = evenCount + oddCount;
    double oddPercentage = (oddCount / (double) sum) * 100;
    double evenPercentage = (evenCount / (double) sum) * 100;
    return String.format("%sOdd numbers: %.2f%nEven numbers: %.2f%n%s",
        getTaskStartDivider(),
        oddPercentage,
        evenPercentage,
        getTaskEndDivider());
  }

  private boolean isEven(BigInteger element) {
    return element.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO);
  }
}

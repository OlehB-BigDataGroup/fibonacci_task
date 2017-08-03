package com.privateapp.fibonacci.tasks;

import com.privateapp.fibonacci.SeriesProvider;
import com.privateapp.fibonacci.utils.Preconditions;

public class PrintExactSeriesElement extends SeriesTask {

  private final int targetElementPosition;

  public PrintExactSeriesElement(int elementPosition) {
    Preconditions.checkArgument(elementPosition < 0);
    targetElementPosition = elementPosition;
  }

  @Override public String perform(SeriesProvider provider, int element) {
    return String.format("%sElement at position %d = %s%n%s",
        getTaskStartDivider(),
        targetElementPosition,
        provider.getElement(element),
        getTaskEndDivider());
  }

  @Override public String getTaskName() {
    return "Find element at position " + targetElementPosition;
  }
}

package com.privateapp.fibonacci.tasks;

import com.privateapp.fibonacci.SeriesProvider;

public class PrintSeriesElements extends SeriesTask {

  @Override public String perform(SeriesProvider provider, int element) {
    StringBuilder result = new StringBuilder();
    result.append(getTaskStartDivider());
    for (int i = 0; i <= element; i++) {
      result.append("Element #").append(i)
          .append(" - ")
          .append(provider.getElement(i))
          .append("\n");
    }
    return result.toString();
  }

  @Override public String getTaskName() {
    return "Print percentage of even and odd numbers";
  }
}

package com.privateapp.fibonacci.tasks;

import com.privateapp.fibonacci.SeriesProvider;
import java.util.ArrayList;
import java.util.List;

public class SeriesStudy extends SeriesTask {

  private final List<SeriesTask> tasks;
  private int minValue = 0;
  private int maxValue = Integer.MAX_VALUE;

  public SeriesStudy(List<SeriesTask> tasks) {
    this.tasks = tasks;
  }

  private boolean checkRange(int number) {
    return number >= minValue
        && number <= maxValue;
  }

  @Override public String perform(SeriesProvider provider, int element) {
    StringBuilder result = new StringBuilder();
    result.append(getTaskStartDivider());
    if (checkRange(element)) {
      for (SeriesTask task : tasks) {
        result.append(task.perform(provider, element));
      }
    } else {
      result.append(String.format("Entered value is out of range [%d, %d]%n", minValue, maxValue));
    }
    result.append(getTaskEndDivider());
    return result.toString();
  }

  @Override public String getTaskName() {
    return "Series task";
  }

  public static class Builder {

    private final List<SeriesTask> tasks = new ArrayList<>();
    private int minValue = 0;
    private int maxValue = Integer.MAX_VALUE;

    public SeriesStudy build() {
      SeriesStudy seriesStudyTask = new SeriesStudy(tasks);
      seriesStudyTask.minValue = minValue;
      seriesStudyTask.maxValue = maxValue;
      return seriesStudyTask;
    }

    public Builder setMinValue(int minValue) {
      this.minValue = minValue;
      return this;
    }

    public Builder setMaxValue(int maxValue) {
      this.maxValue = maxValue;
      return this;
    }

    public Builder addSubTask(SeriesTask task) {
      tasks.add(task);
      return this;
    }
  }
}

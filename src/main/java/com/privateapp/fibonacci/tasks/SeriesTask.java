package com.privateapp.fibonacci.tasks;

import com.privateapp.fibonacci.SeriesProvider;

public abstract class SeriesTask {

  public static final int DIVIDER_WIDTH = 80;
  public static final String START_TASK_PREFIX = "Start of ";
  public static final String END_TASK_PREFIX = "End of task ";
  public static final String ELLIPSES = "...";
  public static final String DIVIDER_SYMBOL = "*";

  protected String getTaskStartDivider() {
    return getDivider(START_TASK_PREFIX);
  }

  protected String getTaskEndDivider() {
    return String.format("%s%n", getDivider(END_TASK_PREFIX));
  }

  private String getDivider(String prefix) {
    String taskName = getTaskName();
    if (taskName.length() > DIVIDER_WIDTH - prefix.length()) {
      return String.format(prefix + "%s%s",
          taskName.substring(0, DIVIDER_WIDTH - prefix.length() - ELLIPSES.length()),
          ELLIPSES);
    }
    StringBuilder result = new StringBuilder();
    int freeSpace = DIVIDER_WIDTH - prefix.length() - taskName.length();
    int dividerPrefixLength = freeSpace / 2;
    for (int i = 0; i < dividerPrefixLength; i++) {
      result.append(DIVIDER_SYMBOL);
    }
    result.append(prefix);
    result.append(taskName);
    int dividerSuffixLength = freeSpace - dividerPrefixLength;
    for (int i = 0; i < dividerSuffixLength; i++) {
      result.append(DIVIDER_SYMBOL);
    }
    result.append("\n");
    return result.toString();
  }

  public abstract String perform(SeriesProvider provider, int element);

  public abstract String getTaskName();
}

package com.privateapp.fibonacci.input;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.privateapp.fibonacci.tasks.SeriesTask.DIVIDER_SYMBOL;
import static com.privateapp.fibonacci.tasks.SeriesTask.DIVIDER_WIDTH;
import static com.privateapp.fibonacci.utils.Preconditions.checkNotNull;

public class IntegerReader {

  private final Scanner scanner;
  private PrintStream printStream;
  private NumberInputListener listener;
  private String startingMessage;
  private String loopingMessage;

  private IntegerReader(InputStream in) {
    this.scanner = new Scanner(checkNotNull(in));
  }

  public static IntegerReader create(InputStream in) {
    return new IntegerReader(in);
  }

  public void startSynchronously() {
    showMessage(startingMessage);
    while (true) {
      String userInput = scanner.nextLine().trim();
      if (userInput.isEmpty()) {
        continue;
      }
      if (isExitCommand(userInput)) {
        return;
      }
      if (isNaturalNumber(userInput)
          && isInteger(userInput)) {
        listener.onNewNumber(Integer.parseInt(userInput));
        showMessage(loopingMessage);
      } else {
        showError(String.format(
            "\"%s\" is not a valid input (Neither non-negative integer nor exit command).",
            userInput));
      }
    }
  }

  public IntegerReader setListener(NumberInputListener listener) {
    this.listener = checkNotNull(listener);
    return this;
  }

  private boolean isExitCommand(String userInput) {
    return userInput.matches("\\s*(?i)exit\\s*");
  }

  private boolean isInteger(String userInput) {
    return userInput.length() < 18
        && Long.parseLong(userInput) <= Integer.MAX_VALUE
        && Long.parseLong(userInput) >= Integer.MIN_VALUE;
  }

  private void showError(String message) {
    if (printStream != null) {
      showErrorDivider();
      showMessage(message);
      showErrorDivider();
    }
  }

  private void showMessage(String message) {
    if (printStream != null) {
      printStream.println(message);
    }
  }

  private void showErrorDivider() {
    for (int i = 0; i < DIVIDER_WIDTH; i++) {
      printStream.print(DIVIDER_SYMBOL);
    }
    printStream.println();
  }

  private boolean isNaturalNumber(String userInput) {
    return userInput.matches("\\s*-?\\d+\\s*");
  }

  public IntegerReader setStartMessage(String startingMessage) {
    this.startingMessage = startingMessage;
    return this;
  }

  public IntegerReader setLoopingMessage(String loopingMessage) {
    this.loopingMessage = loopingMessage;
    return this;
  }

  public IntegerReader setOutputPrintStream(PrintStream out) {
    this.printStream = out;
    return this;
  }

  public interface NumberInputListener {

    void onNewNumber(int number);
  }
}

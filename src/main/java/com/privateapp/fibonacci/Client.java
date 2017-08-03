package com.privateapp.fibonacci;

import com.privateapp.fibonacci.input.IntegerReader;
import com.privateapp.fibonacci.tasks.PrintExactSeriesElement;
import com.privateapp.fibonacci.tasks.PrintOddEvenRatioPercentage;
import com.privateapp.fibonacci.tasks.PrintSeriesElements;
import com.privateapp.fibonacci.tasks.SeriesStudy;
import com.privateapp.fibonacci.utils.StubCache;

public class Client {

  public static void main(String[] args) {
    IntegerReader.create(System.in)
        .setOutputPrintStream(System.err)
        .setStartMessage("Enter Fibonacci series upper bound: ")
        .setLoopingMessage("Enter next bound: ")
        .setListener(Client::startTask)
        .startSynchronously();
  }

  private static void startTask(int userInput) {
    CachingSeriesProvider seriesProvider = new CachingSeriesProvider(
        new FibonacciSeriesProvider(), new StubCache<>());
    String resultOfTask = new SeriesStudy.Builder()
        .addSubTask(new PrintSeriesElements())
        .addSubTask(new PrintOddEvenRatioPercentage())
        .addSubTask(new PrintExactSeriesElement(567))
        .build()
        .perform(seriesProvider, userInput);
    System.out.print(resultOfTask);
  }
}

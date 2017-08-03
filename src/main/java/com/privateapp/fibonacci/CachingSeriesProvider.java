package com.privateapp.fibonacci;

import com.privateapp.fibonacci.utils.Cache;
import com.privateapp.fibonacci.utils.Preconditions;
import java.math.BigInteger;

public class CachingSeriesProvider implements SeriesProvider {

  private final SeriesProvider seriesProvider;
  private final Cache<Integer, BigInteger> cache;

  public CachingSeriesProvider(SeriesProvider provider,
      Cache<Integer, BigInteger> cache) {
    seriesProvider = Preconditions.checkNotNull(provider);
    this.cache = Preconditions.checkNotNull(cache);
  }

  @Override public BigInteger getElement(int elementPosition) {
    return checkCacheForElement(elementPosition)
        ? getFromCache(elementPosition)
        : getAndCacheElement(elementPosition);
  }

  private BigInteger getFromCache(int elementPosition) {
    return cache.getValue(elementPosition);
  }

  private BigInteger getAndCacheElement(int elementPosition) {
    BigInteger element = seriesProvider.getElement(elementPosition);
    cache.put(elementPosition, element);
    return element;
  }

  private boolean checkCacheForElement(int n) {
    return cache.contains(n);
  }
}

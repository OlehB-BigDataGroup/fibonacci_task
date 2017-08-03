package com.privateapp.fibonacci.utils;

public interface Cache<K, V> {

  boolean contains(K key);

  V getValue(K key);

  void put(K elementPosition, V element);
}

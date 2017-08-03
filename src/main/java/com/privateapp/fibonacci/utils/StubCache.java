package com.privateapp.fibonacci.utils;

public class StubCache<K, V> implements Cache<K, V> {

  @Override public boolean contains(K key) {
    return false;
  }

  @Override public V getValue(K key) {
    return null;
  }

  @Override public void put(K elementPosition, V element) {

  }
}

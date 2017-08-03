package com.privateapp.fibonacci;

import java.math.BigInteger;

public interface SeriesProvider {

  BigInteger getElement(int elementPosition);
}


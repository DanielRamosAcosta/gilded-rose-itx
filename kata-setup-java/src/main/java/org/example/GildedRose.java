package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    Arrays.asList(items).forEach(Item::updateQuality);
  }
}
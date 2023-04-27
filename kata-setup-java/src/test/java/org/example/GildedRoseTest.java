package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {
  @Test
  void foo() {
    Item[] items = new Item[] { new Item("fixme", 0, 0) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("fixme", app.items[0].name);
  }

  @Test
  void decrementQualityWhenTimePassed() {
    int quantity = 5;
    int expectedQuantityDecrement = 1;
    int expected = quantity - expectedQuantityDecrement;
    Item[] items = new Item[] { new Item("Apple", 10, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expected, app.items[0].quality);
  }
}

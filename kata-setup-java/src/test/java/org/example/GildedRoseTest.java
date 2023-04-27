package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {
  @Test
  void decreasesQualityByOne() {
    Item[] items = new Item[] { new Item("some-random-item", 5, 5) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, app.items[0].quality);
  }

  @Test
  void decreasesSellInByOne() {
    Item[] items = new Item[] { new Item("some-random-item", 5, 5) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, app.items[0].sellIn);
  }

  @Test
  void decreasesQualityByTwoWhenExpired() {
    Item[] items = new Item[] { new Item("some-random-item", 0, 5) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(3, app.items[0].quality);
  }

  @Test
  void qualityDoesNotGetNegative() {
    Item[] items = new Item[] { new Item("some-random-item", 0, 1) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].quality);
  }
}

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
  void updatesSellInAndQuantityWhenTimePassed() {
    int quantity = 5;
    int expectedQuantity = quantity - 1;
    int sellIn = 10;
    int expectedSellIn = sellIn - 1;
    Item[] items = new Item[] { new Item("Apple", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void decreasesQualityAtDoubleRateWhenSellInIs0() {
    int quantity = 5;
    int expectedQuantity = quantity - 2;
    int sellIn = 0;
    int expectedSellIn = sellIn - 1;
    Item[] items = new Item[] { new Item("Apple", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }
}

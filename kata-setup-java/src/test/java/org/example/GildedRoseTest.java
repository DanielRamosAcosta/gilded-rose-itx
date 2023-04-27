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

  @Test
  void qualityCanNotBeNegative() {
    int quantity = 0;
    int expectedQuantity = 0;
    int sellIn = 5;
    int expectedSellIn = sellIn - 1;
    Item[] items = new Item[] { new Item("Apple", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void agedBrieIncresasesQuality() {
    int quantity = 10;
    int expectedQuantity = quantity+1;
    int sellIn = 5;
    int expectedSellIn = sellIn - 1;
    Item[] items = new Item[] { new Item("Aged Brie", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void agedBrieDecreaseDoubleQualityAfterSellIn() {
    int quantity = 10;
    int expectedQuantity = quantity + 2;
    int sellIn = 0;
    int expectedSellIn = sellIn - 1;
    Item[] items = new Item[] { new Item("Aged Brie", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void quantityTopsAt50() {
    int quantity = 50;
    int expectedQuantity = 50;
    int sellIn = 10;
    int expectedSellIn = sellIn - 1;
    Item[] items = new Item[] { new Item("Aged Brie", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void sulfurasNeverChanges() {
    int quantity = 50;
    int expectedQuantity = 50;
    int sellIn = 10;
    int expectedSellIn = 10;
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }
}

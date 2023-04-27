package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  private final String AGED_BRIE = "Aged Brie";

  private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

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

  @Test
  void brieIncreasesQuality() {
    Item[] items = new Item[] { new Item(AGED_BRIE, 10, 5) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(6, app.items[0].quality);
  }

  @Test
  void brieIncreasesDoubleQualityAfterSellIn() {
    Item[] items = new Item[] { new Item(AGED_BRIE, 0, 5) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(7, app.items[0].quality);
  }

  @Test
  void qualityDoesNotGreaterThan50() {
    Item[] items = new Item[] { new Item(AGED_BRIE, 0, 50) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(50, app.items[0].quality);
  }

  @Test
  void sulfurasDoesNotChangeQuality() {
    Item[] items = new Item[] { new Item(SULFURAS, 0, 10) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(10, app.items[0].quality);
  }

  @Test
  void sulfurasDoesNotChangeSellIn() {
    Item[] items = new Item[] { new Item(SULFURAS, 2, 10) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(2, app.items[0].sellIn);
  }
}

package org.example;

import static org.example.GlidedRoseMother.AGED_BRIE;
import static org.example.GlidedRoseMother.AGED_BRIE_EXCEDED;
import static org.example.GlidedRoseMother.AGED_BRIE_MAX_QUALITY;
import static org.example.GlidedRoseMother.BACKSTAGE_SELL_IN_0;
import static org.example.GlidedRoseMother.BACKSTAGE_SELL_IN_10;
import static org.example.GlidedRoseMother.BACKSTAGE_SELL_IN_5;
import static org.example.GlidedRoseMother.SULFURAS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  // TODO Move to class
  private static final int MAX_QUALITY = 50;

  @Test
  void shouldDegradeQAAtNormalSpeedWhenSoldDateIsExceeded() {
    Item[] items = new Item[] { new Item("foo", 1, 2) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(1, app.items[0].quality);
  }

  @Test
  void shouldDegradeQAAtDoubleSpeedWhenSoldDateIsExceeded() {
    Item[] items = new Item[] { new Item("foo", 0, 2) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].quality);
  }

  @Test
  void qualityShouldBeAlwaysPositive() {
    Item[] items = new Item[] { new Item("foo", 0, 1) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].quality);
  }

  @Test
  void agedBrieIncreaseQAWhenItGetsOlder() {
    Item[] items = new Item[] { AGED_BRIE };
    GildedRose app = new GildedRose(items);
    int expectedQuality = AGED_BRIE.quality;

    app.updateQuality();

    assertEquals(expectedQuality + 1, app.items[0].quality);
  }

  @Test
  void agedBrieIncreaseQAAtDoubleSpeedWhenItGetsOlderAndSoldDateIsExceeded() {
    Item[] items = new Item[] { AGED_BRIE_EXCEDED };
    GildedRose app = new GildedRose(items);
    int expectedQuality = AGED_BRIE_EXCEDED.quality;

    app.updateQuality();

    assertEquals(expectedQuality + 2, app.items[0].quality);
  }

  @Test
  void qualityOfAndItemNeverExceedsMaxQuality() {
    Item[] items = new Item[] { AGED_BRIE_MAX_QUALITY };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(MAX_QUALITY, app.items[0].quality);
  }

  @Test
  void sulfurasNeverVariesInQuality() {
    Item[] items = new Item[] { SULFURAS };
    GildedRose app = new GildedRose(items);
    int expectedQuality = SULFURAS.quality;

    app.updateQuality();

    assertEquals(expectedQuality, app.items[0].quality);
  }

  @Test
  void sulfurasNeverVariesInExpirationDate() {
    Item[] items = new Item[] { SULFURAS };
    GildedRose app = new GildedRose(items);
    int expectedSellIn = SULFURAS.sellIn;

    app.updateQuality();

    assertEquals(expectedSellIn, app.items[0].sellIn);
  }


  @Test
  void backstageIncreasesItsQAWhenSoldDateTenDaysFrom() {
    Item[] items = new Item[] {BACKSTAGE_SELL_IN_10};
    GildedRose app = new GildedRose(items);
    int expectedQuality = BACKSTAGE_SELL_IN_10.quality;

    app.updateQuality();

    assertEquals(expectedQuality + 2, app.items[0].quality);
  }

  @Test
  void backstageIncreasesItsQAWhenSoldDateFiveDaysFrom() {
    Item[] items = new Item[] {BACKSTAGE_SELL_IN_5};
    GildedRose app = new GildedRose(items);
    int expectedQuality = BACKSTAGE_SELL_IN_5.quality;

    app.updateQuality();

    assertEquals(expectedQuality + 3, app.items[0].quality);
  }

  @Test
  void backstageLossesAllQAWhenSoldDateIsExceeded() {
    Item[] items = new Item[] {BACKSTAGE_SELL_IN_0};
    GildedRose app = new GildedRose(items);
    int expectedQuality = BACKSTAGE_SELL_IN_0.quality;

    app.updateQuality();

    assertEquals(expectedQuality, app.items[0].quality);
  }
}

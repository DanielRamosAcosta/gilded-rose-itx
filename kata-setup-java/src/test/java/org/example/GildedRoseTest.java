package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  private  final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

  private final String AGED_BRIE = "Aged Brie";

  private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  private final int MAX_QUALITY = 50;
  public  final int MIN_QUALITY = 0;

  @Test
  void decreasesQualityByOne() {
    int sellIn = 5;
    int quality = 5;
    Item[] items = new Item[] { new Item("some-random-item", sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality - 1, app.items[0].quality);
  }

  @Test
  void decreasesSellInByOne() {
    int sellIn = 5;
    int quality = 5;
    Item[] items = new Item[] { new Item("some-random-item", sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(sellIn - 1, app.items[0].sellIn);
  }

  @Test
  void decreasesQualityByTwoWhenExpired() {
    int sellIn = 0;
    int quality = 5;
    Item[] items = new Item[] { new Item("some-random-item", sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

   assertEquals(quality - 2, app.items[0].quality);
  }

  @Test
  void qualityDoesNotGetNegative() {
    int sellIn = 0;
    int quality = 1;
    Item[] items = new Item[] { new Item("some-random-item", sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(MIN_QUALITY, app.items[0].quality);
  }

  @Test
  void qualityDoesNotGetNegativeWithZeroQuality() {
    int sellIn = 0;
    int quality = MIN_QUALITY;
    Item[] items = new Item[] { new Item("some-random-item", sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality, app.items[0].quality);
  }

  @Test
  void brieIncreasesQuality() {
    int sellIn = 10;
    int quality = 5;
    Item[] items = new Item[] { new Item(AGED_BRIE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality + 1, app.items[0].quality);
  }

  @Test
  void brieIncreasesDoubleQualityAfterSellIn() {
    int sellIn = 0;
    int quality = 5;
    Item[] items = new Item[] { new Item(AGED_BRIE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality + 2, app.items[0].quality);
  }

  @Test
  void qualityDoesNotGreaterThan50() {
    int quality = 50;
    int sellIn = 0;
    Item[] items = new Item[] { new Item(AGED_BRIE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(MAX_QUALITY, app.items[0].quality);
  }

  @Test
  void sulfurasDoesNotChangeQuality() {
    int sellIn = 2;
    int quality = 80;
    Item[] items = new Item[] { new Item(SULFURAS, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality, app.items[0].quality);
  }

  @Test
  void sulfurasDoesNotChangeQualityWhenExpired() {
    int sellIn = -1;
    int quality = 80;
    Item[] items = new Item[] { new Item(SULFURAS, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality, app.items[0].quality);
  }

  @Test
  void sulfurasDoesNotChangeSellIn() {
    int sellIn = 2;
    int quality = 80;
    Item[] items = new Item[] { new Item(SULFURAS, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(sellIn, app.items[0].sellIn);
  }

  @Test
  void backstageIncreasesQuality() {
    int sellIn = 15;
    int quality = 10;
    Item[] items = new Item[] { new Item(BACKSTAGE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality + 1, app.items[0].quality);
  }

  @Test
  void backstageIncreasesDoubleQualityWhen10Days() {
    int sellIn = 10;
    int quality = 10;
    Item[] items = new Item[] { new Item(BACKSTAGE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality + 2, app.items[0].quality);
  }

  @Test
  void backstageIncreasesDoubleQualityWhen10DaysAndNotGreaterThan50() {
    int sellIn = 10;
    int quality = 49;
    Item[] items = new Item[] { new Item(BACKSTAGE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(MAX_QUALITY, app.items[0].quality);
  }

  @Test
  void backstageIncreasesDoubleQualityWhen6Days() {
    int sellIn = 6;
    int quality = 10;
    Item[] items = new Item[] { new Item(BACKSTAGE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality + 2, app.items[0].quality);
  }

  @Test
  void backstageIncreasesDoubleQualityWhen6DaysAndNotGreaterThan50() {
    int sellIn = 6;
    int quality = 49;
    Item[] items = new Item[] { new Item(BACKSTAGE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(MAX_QUALITY, app.items[0].quality);
  }

  @Test
  void backstageIncreasesTripleQualityWhen5Days() {
    int sellIn = 5;
    int quality = 10;
    Item[] items = new Item[] { new Item(BACKSTAGE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality + 3, app.items[0].quality);
  }

  @Test
  void backstageIncreasesTripleQualityWhen5DaysAndNotGreaterThan50() {
    int sellIn = 5;
    int quality = 48;
    Item[] items = new Item[] { new Item(BACKSTAGE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(MAX_QUALITY, app.items[0].quality);
  }

  @Test
  void backstageIncreasesTripleQualityWhen1Days() {
    int sellIn = 1;
    int quality = 10;
    Item[] items = new Item[] { new Item(BACKSTAGE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(quality + 3, app.items[0].quality);
  }

  @Test
  void backstageLosesQualityWhenExpired() {
    int sellIn = 0;
    int quality = 10;
    Item[] items = new Item[] { new Item(BACKSTAGE, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].quality);
  }
}

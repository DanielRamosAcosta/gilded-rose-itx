package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  public static final int MINIMUM_QUALITY = 0;

  public static final int MAXIMUM_QUALITY = 50;

  public static final String AGED_BRIE_ITEM = "Aged Brie";

  public static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";

  public static final String BACKSTAGE_ITEM = "Backstage passes to a TAFKAL80ETC concert";

  @Test
  void qualityNeverIsMinorThanZero() {
    Item[] items = new Item[]{new Item("Generic item", 0, MINIMUM_QUALITY)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertTrue(MINIMUM_QUALITY >= app.items[0].quality);
  }

  @Test
  void qualityNeverIsMayorThanFifty() {
    Item[] items = new Item[]{new Item(AGED_BRIE_ITEM, 0, MAXIMUM_QUALITY)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertTrue(MAXIMUM_QUALITY >= app.items[0].quality);
  }

  @Test
  void brieWithSellInAddOneToQuality() {
    Item[] items = new Item[]{new Item(AGED_BRIE_ITEM, 1, 0)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(1, app.items[0].quality);
  }

  @Test
  void brieWithoutSellInAddOneToQuality() {
    Item[] items = new Item[]{new Item(AGED_BRIE_ITEM, 0, 0)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(2, app.items[0].quality);
  }



  @Test
  void backstageWithSellInAddOneToQuality() {
    Item[] items = new Item[]{new Item(BACKSTAGE_ITEM, 1, 0)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(3, app.items[0].quality);
  }

  @Test
  void backstageWithSellInGreaterThanEleven() {
    Item[] items = new Item[]{new Item(BACKSTAGE_ITEM, 12, 0)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(1, app.items[0].quality);
  }

  @Test
  void backstageWithMaximumQuality() {
    Item[] items = new Item[]{new Item(BACKSTAGE_ITEM, 12, MAXIMUM_QUALITY)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(MAXIMUM_QUALITY, app.items[0].quality);
  }

  @Test
  void backstageWithMaximumQualityAndSellInUnder10() {
    Item[] items = new Item[]{new Item(BACKSTAGE_ITEM, 8, 49)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(MAXIMUM_QUALITY, app.items[0].quality);
  }

  @Test
  void backstageWithMaximumQualityAndSellInUnder5() {
    Item[] items = new Item[]{new Item(BACKSTAGE_ITEM, 4, 49)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(MAXIMUM_QUALITY, app.items[0].quality);
  }

  @Test
  void backstageWithSellInBetweenFiveAndTenAddOneToQuality() {
    Item[] items = new Item[]{new Item(BACKSTAGE_ITEM, 7, 0)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(2, app.items[0].quality);
  }

  @Test
  void backstageWithSellInZeroAddOneToQuality() {
    Item[] items = new Item[]{new Item(BACKSTAGE_ITEM, 0, 1)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(0, app.items[0].quality);
  }

  @Test
  void sulfurasMaintainSellInAndQuality() {
    Item[] items = new Item[]{new Item(SULFURAS_ITEM, 5, 7)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(5, app.items[0].sellIn);
    assertEquals(7, app.items[0].quality);
  }

  @Test
  void sulfurasMaintainSellInAndQualityAtZero() {
    Item[] items = new Item[]{new Item(SULFURAS_ITEM, -1, 1)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(-1, app.items[0].sellIn);
    assertEquals(1, app.items[0].quality);
  }

  @Test
  void genericItem() {
    Item[] items = new Item[]{new Item("Generic", 1, 1)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Generic", app.items[0].name);
    assertEquals(0, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }

  @Test
  void genericItemSellInNegative() {
    Item[] items = new Item[]{new Item("Generic", -1, 2)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    Item item = app.items[0];;
    assertEquals("Generic, -2, 0",item.toString());
  }
}

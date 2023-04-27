package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  public static final int MINIMUM_QUALITY = 0;

  public static final int MAXIMUM_QUALITY = 50;

  @Test
  void qualityNeverIsMinorThanZero() {
    Item[] items = new Item[]{new ItemGeneric("Generic item", 0, MINIMUM_QUALITY)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertTrue(MINIMUM_QUALITY >= app.items[0].quality);
  }

  @Test
  void qualityNeverIsMayorThanFifty() {
    Item[] items = new Item[]{new ItemAgedBrie( 0, MAXIMUM_QUALITY)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertTrue(MAXIMUM_QUALITY >= app.items[0].quality);
  }

  @Test
  void brieWithSellInAddOneToQuality() {
    Item[] items = new Item[]{new ItemAgedBrie( 1, 0)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(1, app.items[0].quality);
  }

  @Test
  void brieWithoutSellInAddOneToQuality() {
    Item[] items = new Item[]{new ItemAgedBrie( 0, 0)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(2, app.items[0].quality);
  }



  @Test
  void backstageWithSellInAddOneToQuality() {
    Item[] items = new Item[]{new ItemBackstage( 1, 0)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(3, app.items[0].quality);
  }

  @Test
  void backstageWithSellInGreaterThanEleven() {
    Item[] items = new Item[]{new ItemBackstage( 12, 0)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(1, app.items[0].quality);
  }

  @Test
  void backstageWithMaximumQuality() {
    Item[] items = new Item[]{new ItemBackstage( 12, MAXIMUM_QUALITY)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(MAXIMUM_QUALITY, app.items[0].quality);
  }

  @Test
  void backstageWithMaximumQualityAndSellInUnder10() {
    Item[] items = new Item[]{new ItemBackstage( 8, 49)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(MAXIMUM_QUALITY, app.items[0].quality);
  }

  @Test
  void backstageWithMaximumQualityAndSellInUnder5() {
    Item[] items = new Item[]{new ItemBackstage( 4, 49)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(MAXIMUM_QUALITY, app.items[0].quality);
  }

  @Test
  void backstageWithSellInBetweenFiveAndTenAddOneToQuality() {
    Item[] items = new Item[]{new ItemBackstage( 7, 0)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(2, app.items[0].quality);
  }

  @Test
  void backstageWithSellInZeroAddOneToQuality() {
    Item[] items = new Item[]{new ItemBackstage( 0, 1)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(0, app.items[0].quality);
  }

  @Test
  void sulfurasMaintainSellInAndQuality() {
    Item[] items = new Item[]{new ItemSulfuras( 5, 7)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(5, app.items[0].sellIn);
    assertEquals(7, app.items[0].quality);
  }

  @Test
  void sulfurasMaintainSellInAndQualityAtZero() {
    Item[] items = new Item[]{new ItemSulfuras( -1, 1)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    assertEquals(-1, app.items[0].sellIn);
    assertEquals(1, app.items[0].quality);
  }

  @Test
  void genericItem() {
    Item[] items = new Item[]{new ItemGeneric("Generic", 1, 1)};
    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);
    assertEquals("Generic", app.items[0].name);
    assertEquals(0, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }

  @Test
  void genericItemSellInNegative() {
    Item[] items = new Item[]{new ItemGeneric("Generic", -1, 2)};

    GildedRose app = new GildedRose(items);
    GildedRose.updateQuality(app);

    Item item = app.items[0];;
    assertEquals("Generic, -2, 0",item.toString());
  }
}

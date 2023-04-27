package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

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
  void doesNotDecreaseQualityAt0() {
    int quantity = 0;
    int expectedQuantity = 0;
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
  void agedBrieTopsAt50() {
    int quantity = 49;
    int expectedQuantity = quantity + 1;
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
    int quantity = 80;
    int expectedQuantity = 80;
    int sellIn = 10;
    int expectedSellIn = 10;
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void sulfurasNeverChangesEvenIfExpired() {
    int quantity = 80;
    int expectedQuantity = 80;
    int sellIn = -1;
    int expectedSellIn = -1;
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void backstageIncreasesQuality() {
    int quantity = 20;
    int expectedQuantity = quantity+1;
    int sellIn = 20;
    int expectedSellIn = sellIn- 1;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void backstageIncreasesAtDoubleRateWhenSellInIsBetween10and5() {
    int quantity = 20;
    int expectedQuantity = quantity+2;
    int sellIn = 10;
    int expectedSellIn = sellIn- 1;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void backstageIncreasesAtTripleRateWhenSellInIsBetween5Or0() {
    int quantity = 20;
    int expectedQuantity = quantity+3;
    int sellIn = 5;
    int expectedSellIn = sellIn- 1;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void backstageIncreasesAtTripleRateWhenSellInLess0() {
    int quantity = 20;
    int expectedQuantity = 0;
    int sellIn = 0;
    int expectedSellIn = sellIn - 1;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void backstageTopsAt50WhenNormalDate() {
    int quantity = 49;
    int expectedQuantity = 50;
    int sellIn = 9;
    int expectedSellIn = sellIn- 1;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  @Test
  void backstageTopsAt50WhenDoubleDate() {
    int quantity = 49;
    int expectedQuantity = 50;
    int sellIn = 5;
    int expectedSellIn = sellIn- 1;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }

  //TODO: We should reset items to 50 if defined with more
  @Test
  @Disabled
  void NoItemExceptSulfurasIsGreaterThan50() {
    int quantity = 60;
    int expectedQuantity = 50;
    int sellIn = 20;
    int expectedSellIn = sellIn - 1;
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quantity) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(expectedQuantity, app.items[0].quality);
    assertEquals(expectedSellIn, app.items[0].sellIn);
  }
}

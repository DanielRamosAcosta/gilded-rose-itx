package org.example;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public static void updateQuality(GildedRose gildedRose) {
    for (Item item : gildedRose.items) {
      if (item.isAgedBrie() || item.isBackstage()) {
        item.increaseQualityWithCheck();

        if (item.isBackstage()) {
          if (item.sellInIsLowerThanTen()) {
            item.increaseQualityWithCheck();
          }

          if (item.sellInIsLowerThanFive()) {
            item.increaseQualityWithCheck();
          }
        }
      } else {
        item.decrementQualityWithCheck();
      }

      item.sellInDecrease();

      if (item.sellIn < 0) {
        if (!item.isAgedBrie()) {
          if (!item.isBackstage()) {
            item.decrementQualityWithCheck();
          } else {
            item.resetQuality();
          }
        } else {
          item.increaseQualityWithCheck();
        }
      }
    }
  }

}
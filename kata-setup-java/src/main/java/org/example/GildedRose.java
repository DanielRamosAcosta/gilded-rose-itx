package org.example;

class GildedRose {

  public static final String AGED_BRIE = "Aged Brie";

  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  public static final int MAX_QUALITY = 50;

  public static final int MIN_QUALITY = 0;

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public static void updateQuality(GildedRose gildedRose) {
    for (Item item : gildedRose.items) {
      if (!item.isAgedBrie()
          && !item.isBackstage()) {
        if (item.theQualityIsAboveTheMinimum()) {
          if (!item.isSulfuras()) {
            item.quality = item.decrementQuality();
          }
        }
      } else {
        if (item.hasMaxQuality()) {
          item.quality = item.increaseQuality();

          if (item.isBackstage()) {
            if (sellInIsLowerThanTen(item)) {
              if (item.hasMaxQuality()) {
                item.quality = item.increaseQuality();
              }
            }

            if (sellInIsLowerThanFive(item)) {
              if (item.hasMaxQuality()) {
                item.quality = item.increaseQuality();
              }
            }
          }
        }
      }

      if (!item.isSulfuras()) {
        item.sellIn = sellInDecrease(item);
      }

      if (item.sellIn < MIN_QUALITY) {
        if (!item.isAgedBrie()) {
          if (!item.isBackstage()) {
            if (item.theQualityIsAboveTheMinimum()) {
              if (!item.isSulfuras()) {
                item.quality = item.decrementQuality();
              }
            }
          } else {
            item.quality = resetQuality(item);
          }
        } else {
          if (item.hasMaxQuality()) {
            item.quality = item.increaseQuality();
          }
        }
      }
    }
  }

  private static int resetQuality(Item item) {
    return item.quality - item.quality;
  }

  private static int sellInDecrease(Item item) {
    return item.sellIn - 1;
  }

  private static boolean sellInIsLowerThanFive(Item item) {
    return item.sellIn <= 5;
  }

  private static boolean sellInIsLowerThanTen(Item item) {
    return item.sellIn <= 10;
  }

}
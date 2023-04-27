package org.example;

class GildedRose {

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
        if (item.hasLowerThanMaxQuality()) {
          item.quality = item.increaseQuality();

          if (item.isBackstage()) {
            if (sellInIsLowerThanTen(item)) {
              if (item.hasLowerThanMaxQuality()) {
                item.quality = item.increaseQuality();
              }
            }

            if (sellInIsLowerThanFive(item)) {
              if (item.hasLowerThanMaxQuality()) {
                item.quality = item.increaseQuality();
              }
            }
          }
        }
      }

      if (!item.isSulfuras()) {
        item.sellIn = sellInDecrease(item);
      }

      if (item.sellIn < Item.MIN_QUALITY) {
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
          if (item.hasLowerThanMaxQuality()) {
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
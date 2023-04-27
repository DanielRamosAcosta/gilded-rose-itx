package org.example;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public static void updateQuality(GildedRose gildedRose) {
    for (Item item : gildedRose.items) {
      if (item.isAgedBrie()
          || item.isBackstage()) {
            if (item.hasLowerThanMaxQuality()) {
              item.increaseQualityWithCheck();

              if (item.isBackstage()) {
                if (item.sellInIsLowerThanTen()) {
                  item.increaseQualityWithCheck();
                }

                if (item.sellInIsLowerThanFive()) {
                  item.increaseQualityWithCheck();
                }
              }
            }
          } else {
        if (item.theQualityIsAboveTheMinimum()) {
          if (!item.isSulfuras()) {
            item.quality = item.decrementQuality();
          }
        }
      }

      if (!item.isSulfuras()) {
        item.sellIn = item.sellInDecrease();
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
            item.quality = item.resetQuality();
          }
        } else {
          item.increaseQualityWithCheck();
        }
      }
    }
  }

}
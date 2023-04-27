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
            if (item.sellInIsLowerThanTen()) {
              if (item.hasLowerThanMaxQuality()) {
                item.quality = item.increaseQuality();
              }
            }

            if (item.sellInIsLowerThanFive()) {
              if (item.hasLowerThanMaxQuality()) {
                item.quality = item.increaseQuality();
              }
            }
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
          if (item.hasLowerThanMaxQuality()) {
            item.quality = item.increaseQuality();
          }
        }
      }
    }
  }

}
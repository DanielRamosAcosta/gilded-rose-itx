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
            if (item.sellInIsLowerThanTen()) {
              if (item.hasMaxQuality()) {
                item.quality = item.increaseQuality();
              }
            }

            if (item.sellInIsLowerThanFive()) {
              if (item.hasMaxQuality()) {
                item.quality = item.increaseQuality();
              }
            }
          }
        }
      }

      if (!item.isSulfuras()) {
        item.sellIn = item.sellInDecrease();
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
            item.quality = item.resetQuality();
          }
        } else {
          if (item.hasMaxQuality()) {
            item.quality = item.increaseQuality();
          }
        }
      }
    }
  }

}
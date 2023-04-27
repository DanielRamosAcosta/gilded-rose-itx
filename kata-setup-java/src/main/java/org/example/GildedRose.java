package org.example;

class GildedRose {

  public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

  public static final String AGED_BRIE = "Aged Brie";

  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items)
      updateItemQuality(item);
  }

  private static void updateItemQuality(Item item) {
    if(isSulfuras(item)) {
      return;
    }

    if (!isAgedBrie(item)
        && !isBackstage(item)) {
      if (item.quality > 0) {
        item.quality = item.quality - 1;
      }
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1;

        if (isBackstage(item)) {
          if (item.sellIn < 11) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }

          if (item.sellIn < 6) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }
        }
      }
    }

    item.sellIn = item.sellIn - 1;

    if (item.sellIn < 0) {
      if (!isAgedBrie(item)) {
        if (!isBackstage(item)) {
          if (item.quality > 0) {
            item.quality = item.quality - 1;
          }
        } else {
          item.quality = item.quality - item.quality;
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
    }
  }

  private static boolean isBackstage(Item item) {
    return item.name.equals(BACKSTAGE_PASS);
  }

  private static boolean isAgedBrie(Item item) {
    return item.name.equals(AGED_BRIE);
  }

  private static boolean isSulfuras(Item item) {
    return item.name.equals(SULFURAS);
  }
}
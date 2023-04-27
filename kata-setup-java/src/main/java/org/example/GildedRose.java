package org.example;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {

      if (isSulfuras(item)) {
        continue;
      }

      item.preDecreaseSellIn();
      item.decreaseSellIn();

      if (item.sellIn < 0) {
        if (isAgedBrie(item)) {
          if (item.quality < 50) {
            item.quality = item.quality + 1;
          }
        } else if (!isBackstagePasses(item)) {
          if (item.quality > 0) {
            item.quality = item.quality - 1;
          }
        } else {
          item.quality = 0;
        }
      }
    }

  }

  private static boolean isSulfuras(Item item) {
    return item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  private static boolean isBackstagePasses(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  private static boolean isAgedBrie(Item item) {
    return item.name.equals("Aged Brie");
  }
}
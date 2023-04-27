package org.example;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (!item.isAgedBrie()
          && !item.isBackstage()) {
        if (!item.hasMinimumQuality()) {
          if (!item.isSulfuras()) {
            item.quality = item.quality - 1;
          }
        }
      } else {
        if (item.hasMaxQuality()) {
          item.quality = item.quality + 1;

          if (item.isBackstage()) {
            if (item.sellIn < 11) {
              item.increaseQuality();
            }

            if (item.sellIn < 6) {
              item.increaseQuality();
            }
          }
        }
      }

      if (!item.isSulfuras()) {
        item.sellIn = item.sellIn - 1;
      }

      if (item.sellIn < 0) {
        if (!item.isAgedBrie()) {
          if (!item.isBackstage()) {
            if (!item.hasMinimumQuality()) {
              if (!item.isSulfuras()) {
                item.quality = item.quality - 1;
              }
            }
          } else {
            item.quality = 0;
          }
        } else {
          item.increaseQuality();
        }
      }
    }
  }

}
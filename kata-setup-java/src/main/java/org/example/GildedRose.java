package org.example;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items)
      updateItemQuality(item);
  }

  private static void updateItemQuality(Item item) {
    if(item.isSulfuras()) {
      return;
    }

    if (!item.isAgedBrie()
        && !item.isBackstage()) {
      if (item.canReduceQuality()) {
        item.quality = item.quality - 1;
      }
    } else {
      if (item.canIncreaseQuality()) {
        item.quality = item.quality + 1;

        if (item.isBackstage()) {
          if (item.sellIn < 11) {
            if (item.canIncreaseQuality()) {
              item.quality = item.quality + 1;
            }
          }

          if (item.sellIn < 6) {
            if (item.canIncreaseQuality()) {
              item.quality = item.quality + 1;
            }
          }
        }
      }
    }

    item.sellIn = item.sellIn - 1;

    if (item.sellIn < Item.MIN_SELL_IN) {
      if (!item.isAgedBrie()) {
        if (!item.isBackstage()) {
          if (item.canReduceQuality()) {
            item.quality = item.quality - 1;
          }
        } else {
          item.quality = Item.MIN_QUALITY;
        }
      } else {
        if (item.canIncreaseQuality()) {
          item.quality = item.quality + 1;
        }
      }
    }
  }

}
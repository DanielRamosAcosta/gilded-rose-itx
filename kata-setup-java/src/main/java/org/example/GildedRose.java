package org.example;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateItemQuality(item);
    }
  }

  private static void updateItemQuality(Item item) {
    if (item.isSulfuras()) {
      return;
    }

    item.sellIn = item.sellIn - 1;

    if (item.isAgedBrie() || item.isBackstage()) {
      item.increaseQuality();

      if (item.isBackstage()) {
        if (item.sellIn < 10) {
          item.increaseQuality();
        }

        if (item.sellIn < 5) {
          item.increaseQuality();
        }
      }
    } else {
      item.decreaseQuality();
    }


    if (!item.isExpired()) {
      return;
    }

    if (item.isBackstage()) {
      item.removeQuality();
      return;
    }

    if (item.isAgedBrie()) {
      item.increaseQuality();
      return;
    }

    item.decreaseQuality();
  }

}
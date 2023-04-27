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

    if (!item.isAgedBrie()
        && !item.isBackstage()) {
      item.decreaseQuality();
    } else {
      item.increaseQuality();

      if (item.isBackstage()) {
        if (item.sellIn < 11) {
          item.increaseQuality();
        }

        if (item.sellIn < 6) {
          item.increaseQuality();
        }
      }

    }

    item.sellIn = item.sellIn - 1;

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
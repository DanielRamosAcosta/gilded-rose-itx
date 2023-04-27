package org.example;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {

      item.decreaseSellIn();

      if (item.isBackstage()) {
        item.increaseBackstageQuality();
      } else if (item.isAgedBrie()) {
        item.increaseAgedBrieQuality();
      } else if (item.isSulfuras()) {
        item.increaseSulfurasQuality();
      } else {

        item.increaseDefaultItem();
      }
    }
  }

}
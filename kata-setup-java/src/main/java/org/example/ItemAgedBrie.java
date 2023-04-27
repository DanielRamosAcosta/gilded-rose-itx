package org.example;

public class ItemAgedBrie extends Item {

  public ItemAgedBrie(int sellIn, int quality) {
    super("Aged Brie", sellIn, quality);
  }

  @Override
  public void doUpdateQuality() {
    if (hasPassedSellIn()) {
      quality = quality + 2;
    } else {
      quality = quality + 1;
    }
  }
}

package org.example;

public class ItemAgedBrie extends Item {

  public ItemAgedBrie(int sellIn, int quality) {
    super("Aged Brie", sellIn, quality);
  }

  @Override
  public void preDecreaseSellIn() {
    if (quality < 50) {
      quality = quality + 1;
    }
  }

  @Override
  public void postDecreaseSellIn() {
    if (sellIn < 0) {
      if (quality < 50) {
        quality = quality + 1;
      }
    }
  }
}

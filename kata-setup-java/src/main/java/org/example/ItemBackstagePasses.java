package org.example;

public class ItemBackstagePasses extends Item {

  public ItemBackstagePasses(int sellIn, int quality) {
    super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
  }

  @Override
  public void preDecreaseSellIn() {
    if (quality < 50) {
      quality = quality + 1;
    }
    if (sellIn < 11) {
      quality = quality + 1;
    }
    if (sellIn < 6) {
      quality = quality + 1;
    }
  }

  @Override
  public void postDecreaseSellIn() {
    if (sellIn < 0) {
      quality = 0;
    }
  }
}

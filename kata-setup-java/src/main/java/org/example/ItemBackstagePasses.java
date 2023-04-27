package org.example;

public class ItemBackstagePasses extends Item {

  public ItemBackstagePasses(int sellIn, int quality) {
    super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (hasPassedSellIn()) {
      quality = 0;
    } else {
      quality = quality + 1;
      if (sellIn < 11) {
        quality = quality + 1;
      }
      if (sellIn < 6) {
        quality = quality + 1;
      }
      if (quality > 50) {
        quality = 50;
      }
    }
  }
}

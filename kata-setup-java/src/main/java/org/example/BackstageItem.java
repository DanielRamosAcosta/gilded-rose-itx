package org.example;

public class BackstageItem extends Item{

  public BackstageItem(int sellIn, int quality) {
    super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (sellIn == 0) {
      quality = 0;
    } else if (sellIn < 5) {
      quality = quality + 3;
    } else if (sellIn < 10) {
      quality = quality + 2;
    }
  }
}

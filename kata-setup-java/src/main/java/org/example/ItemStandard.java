package org.example;

public class ItemStandard extends Item {

  public ItemStandard(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (hasPassedSellIn()) {
      quality = quality - 2;
    } else {
      quality = quality - 1;
    }
    if (quality < 0) {
      quality = 0;
    }
  }

}

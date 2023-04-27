package org.example;

public class ItemStandard extends Item {

  public ItemStandard(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void doUpdateQuality() {
    if (hasPassedSellIn()) {
      quality.decrease(2);
    } else {
      quality.decrease(1);
    }
  }

}

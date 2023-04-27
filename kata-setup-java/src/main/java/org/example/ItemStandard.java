package org.example;

public class ItemStandard extends Item {

  public ItemStandard(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void preDecreaseSellIn() {
    if (quality > 0) {
      quality = quality - 1;
    }
  }

  @Override
  public void postDecreaseSellIn() {
    if (sellIn < 0) {
      if (quality > 0) {
        quality = quality - 1;
      }
    }
  }

}

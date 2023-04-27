package org.example;

public class AgedBrie extends Item {

  public AgedBrie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void decreaseSellIn() {
    super.decreaseSellIn();
  }

  @Override
  void decreaseQuality() {
    super.decreaseQuality();
  }

  @Override
  void increaseQuality() {
    super.increaseQuality();
  }
}

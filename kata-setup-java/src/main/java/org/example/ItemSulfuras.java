package org.example;

public class ItemSulfuras extends Item {

  public ItemSulfuras(int sellIn, int quality) {
    super("Sulfuras, Hand of Ragnaros", sellIn, quality);
  }

  @Override
  public void preDecreaseSellIn() {
    // Nothing
  }

  @Override
  public void decreaseSellIn() {
    // Nothing
  }
}

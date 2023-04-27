package org.example;

public class ItemSulfuras extends Item {

  public ItemSulfuras(int sellIn, int quality) {
    super("Sulfuras, Hand of Ragnaros", sellIn, quality);
  }

  @Override
  public void decreaseSellIn() {
    // Nothing
  }

  @Override
  public void updateQuality() {
    // Nothing
  }
}

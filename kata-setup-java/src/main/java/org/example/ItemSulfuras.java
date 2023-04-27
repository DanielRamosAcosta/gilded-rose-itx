package org.example;

public class ItemSulfuras extends Item {

  private static final int FIXED_QUALITY = 80;

  public ItemSulfuras(int sellIn) {
    super("Sulfuras, Hand of Ragnaros", sellIn, FIXED_QUALITY);
  }

  @Override
  public void decreaseSellIn() {
    // Nothing
  }

  @Override
  public void doUpdateQuality() {
    // Nothing
  }

  @Override
  protected void enforceQuality() {
    // Nothing
  }
}

package org.example;

public abstract class Item {

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public void decreaseSellIn() {
    sellIn -= 1;
  }

  public void updateQuality() {
    doUpdateQuality();
    enforceQuality();
  }

  protected abstract void doUpdateQuality();

  protected boolean hasPassedSellIn() {
    return sellIn < 0;
  }

  protected void enforceQuality() {
    if (quality < 0) {
      quality = 0;
    }
    if (quality > 50) {
      quality = 50;
    }
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

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

  public boolean hasPassedSellIn() {
    return sellIn < 0;
  }

  public abstract void preDecreaseSellIn();

  public void decreaseSellIn() {
    sellIn -= 1;
  }

  public abstract void postDecreaseSellIn();

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

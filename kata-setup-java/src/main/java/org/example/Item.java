package org.example;

import org.example.quality.Quality;

public abstract class Item {

  public String name;

  public int sellIn;

  public Quality quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = new Quality(quality);
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
    quality.enforceIsNotBelowZero();
    quality.enforceIsNotOverFifty();
  }

  public boolean hasQualityValue(int value) {
    return quality.hasQualityValue(value);
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

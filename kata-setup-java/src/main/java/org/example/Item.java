package org.example;

public class Item {

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  private boolean isNotSulfuras() {
    return !(this instanceof SulfurasItem);
  }

  protected void ensureQualityNotExcededMinLimit() {
    if (isNotSulfuras() && quality < 0) {
      quality = quality + 1;
    }
  }

  protected void ensureQualityNotExcededMaxLimit() {
    if (isNotSulfuras() && quality > 50) {
      quality = quality - 1;
    }
  }

  public void updateQuality() {
    if (sellIn == 0) {
      quality = quality - 2;
    } else {
      sellIn = sellIn - 1;
      quality = quality - 1;
    }
    ensureQualityNotExcededMaxLimit();
    ensureQualityNotExcededMinLimit();
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

package org.example;

public class Item {

  public static final int MAX_QUALITY = 50;

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  void update() {
    decreaseSellIn();
    decreaseQuality();
    if (hasExpired()) {
      decreaseQuality();
    }
  }

  boolean hasExpired() {
    return this.sellIn < 0;
  }

  void decreaseSellIn() {
    this.sellIn = this.sellIn - 1;

  }

  void decreaseQuality() {
    if (!hasMinimumQuality()) {
      this.quality = this.quality - 1;
    }
  }

  void increaseQuality() {
    if (!hasMaxQuality()) {
      this.quality = this.quality + 1;
    }
  }

  boolean hasMinimumQuality() {
    return this.quality <= 0;
  }

  boolean isBackstage() {
    return this.name.equals(Backstage.BACKSTAGE_PASS);
  }

  boolean isAgedBrie() {
    return this.name.equals(AgedBrie.AGED_BRIE);
  }

  boolean isSulfuras() {
    return this.name.equals(Sulfuras.SULFURAS);
  }

  boolean hasMaxQuality() {
    return this.quality >= MAX_QUALITY;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

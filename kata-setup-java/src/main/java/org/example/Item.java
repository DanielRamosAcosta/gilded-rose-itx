package org.example;

public abstract class Item {

  public static final String AGED_BRIE = "Aged Brie";

  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  public static final int MAX_QUALITY = 50;

  public static final int MIN_QUALITY = 0;

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public void decrementQualityWithCheck() {
    if (this.quality > MIN_QUALITY && !isSulfuras()) {
      this.quality = decrementQuality();
    }
  }

  public void increaseQualityWithCheck() {
    if (hasLowerThanMaxQuality() && !isSulfuras()) {
      this.quality = increaseQuality();
    }
  }

  public boolean sellInIsLowerThanTen() {
    return this.sellIn <= 10;
  }

  public boolean sellInIsLowerThanFive() {
    return this.sellIn <= 5;
  }

  public void sellInDecrease() {
    if (!this.isSulfuras()) {
      this.sellIn--;
    }
  }

  public void resetQuality() {
    this.quality = 0;
  }

  boolean theQualityIsAboveTheMinimum() {
    return this.quality > MIN_QUALITY;
  }

  int decrementQuality() {
    return this.quality - 1;
  }

  public boolean hasLowerThanMaxQuality() {
    return this.quality < MAX_QUALITY;
  }

  int increaseQuality() {
    return this.quality + 1;
  }

  public boolean isAgedBrie() {
    return this.name.equals(AGED_BRIE);
  }

  public boolean isBackstage() {
    return this.name.equals(BACKSTAGE_PASSES);
  }

  public boolean isSulfuras() {
    return this.name.equals(SULFURAS);
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

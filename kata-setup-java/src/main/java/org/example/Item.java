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

  public boolean sellInIsLowerThanTen() {
    return this.sellIn <= 10;
  }

  public boolean sellInIsLowerThanFive() {
    return this.sellIn <= 5;
  }

  public int sellInDecrease() {
    return this.sellIn - 1;
  }

  public int resetQuality() {
    return this.quality - this.quality;
  }

  boolean theQualityIsAboveTheMinimum() {
    return this.quality > GildedRose.MIN_QUALITY;
  }

  public int decrementQuality() {
    return this.quality - 1;
  }

  public boolean hasMaxQuality() {
    return this.quality < GildedRose.MAX_QUALITY;
  }

  public int increaseQuality() {
    return this.quality + 1;
  }

  public boolean isAgedBrie() {
    return this.name.equals(GildedRose.AGED_BRIE);
  }

  public boolean isBackstage() {
    return this.name.equals(GildedRose.BACKSTAGE_PASSES);
  }

  public boolean isSulfuras() {
    return this.name.equals(GildedRose.SULFURAS);
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

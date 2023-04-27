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

package org.example;

public class Item {

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

  boolean theQualityIsAboveTheMinimum() {
    return this.quality > MIN_QUALITY;
  }

  public int decrementQuality() {
    return this.quality - 1;
  }

  public boolean hasLowerThanMaxQuality() {
    return this.quality < MAX_QUALITY;
  }

  public int increaseQuality() {
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

package org.example;

public class Item {

  public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

  public static final String AGED_BRIE = "Aged Brie";

  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  public static final int MAX_QUALITY = 50;

  public static final int MIN_QUALITY = 0;

  static final int MIN_SELL_IN = 0;

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  void increaseQuality() {
    if (canIncreaseQuality()) {
      quality = quality + 1;
    }
  }

  boolean isExpired() {
    return this.sellIn < MIN_SELL_IN;
  }

  boolean canIncreaseQuality() {
    return this.quality < MAX_QUALITY;
  }

  boolean isBackstage() {
    return name.equals(BACKSTAGE_PASS);
  }

  boolean isAgedBrie() {
    return name.equals(AGED_BRIE);
  }

  boolean isSulfuras() {
    return name.equals(SULFURAS);
  }

  boolean canReduceQuality() {
    return quality > MIN_QUALITY;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

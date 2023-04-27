package org.example;

public class Item {

  public static final int MAX_QUALITY = 50;

  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  public static final String AGED_BRIE = "Aged Brie";

  public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  void update() {
    decreaseQuality();
    if (hasExpired()) {
      decreaseQuality();
    }
  }

  boolean hasExpired() {
    return this.sellIn < 0;
  }

  void decreaseSellIn() {
    if (!isSulfuras()) {
      this.sellIn = this.sellIn - 1;
    }
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
    return this.name.equals(BACKSTAGE_PASS);
  }

  boolean isAgedBrie() {
    return this.name.equals(AGED_BRIE);
  }

  boolean isSulfuras() {
    return this.name.equals(SULFURAS);
  }

  boolean hasMaxQuality() {
    return this.quality >= MAX_QUALITY;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

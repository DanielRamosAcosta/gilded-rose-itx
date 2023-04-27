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

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}

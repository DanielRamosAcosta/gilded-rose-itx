package org.example.mothers;

import org.example.Item;

public class ItemMother {

  public static Item createWine(int sellIn, int quality) {
    return new Item("Wine", sellIn, quality);
  }

  public static Item createAgedBrie(int sellIn, int quality) {
    return new Item("Aged Brie", sellIn, quality);
  }

  public static Item createSulfuras(int sellIn, int quality) {
    return new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
  }

  public static Item createBackstagePasses(int sellIn, int quality) {
    return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
  }
}

package org.example.mothers;

import org.example.Item;
import org.example.ItemAgedBrie;
import org.example.ItemBackstagePasses;
import org.example.ItemStandard;
import org.example.ItemSulfuras;

public class ItemMother {

  public static Item createWine(int sellIn, int quality) {
    return new ItemStandard("Wine", sellIn, quality);
  }

  public static Item createAgedBrie(int sellIn, int quality) {
    return new ItemAgedBrie(sellIn, quality);
  }

  public static Item createSulfuras(int sellIn, int quality) {
    return new ItemSulfuras(sellIn, quality);
  }

  public static Item createBackstagePasses(int sellIn, int quality) {
    return new ItemBackstagePasses(sellIn, quality);
  }
}

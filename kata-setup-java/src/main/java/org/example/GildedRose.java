package org.example;

class GildedRose {

  public static final String AGED_BRIE = "Aged Brie";

  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  public static final int MAX_QUALITY = 50;

  public static final int MIN_QUALITY = 0;

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = MIN_QUALITY; i < items.length; i++) {
      if (!items[i].name.equals(AGED_BRIE)
          && !items[i].name.equals(BACKSTAGE_PASSES)) {
        if (items[i].quality > MIN_QUALITY) {
          if (!items[i].name.equals(SULFURAS)) {
            items[i].quality = items[i].quality - 1;
          }
        }
      } else {
        if (items[i].quality < MAX_QUALITY) {
          items[i].quality = items[i].quality + 1;

          if (items[i].name.equals(BACKSTAGE_PASSES)) {
            if (items[i].sellIn <= 10) {
              if (items[i].quality < MAX_QUALITY) {
                items[i].quality = items[i].quality + 1;
              }
            }

            if (items[i].sellIn <= 5) {
              if (items[i].quality < MAX_QUALITY) {
                items[i].quality = items[i].quality + 1;
              }
            }
          }
        }
      }

      if (!items[i].name.equals(SULFURAS)) {
        items[i].sellIn = items[i].sellIn - 1;
      }

      if (items[i].sellIn < MIN_QUALITY) {
        if (!items[i].name.equals(AGED_BRIE)) {
          if (!items[i].name.equals(BACKSTAGE_PASSES)) {
            if (items[i].quality > MIN_QUALITY) {
              if (!items[i].name.equals(SULFURAS)) {
                items[i].quality = items[i].quality - 1;
              }
            }
          } else {
            items[i].quality = items[i].quality - items[i].quality;
          }
        } else {
          if (items[i].quality < MAX_QUALITY) {
            items[i].quality = items[i].quality + 1;
          }
        }
      }
    }
  }
}
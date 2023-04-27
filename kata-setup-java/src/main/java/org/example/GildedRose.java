package org.example;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (!item.name.equals(Item.AGED_BRIE)
          && !item.name.equals(Item.BACKSTAGE_PASS)) {
        if (item.quality > 0) {
          if (!item.name.equals(Item.SULFURAS)) {
            item.quality = item.quality - 1;
          }
        }
      } else {
        if (item.quality < Item.MAX_QUALITY) {
          item.quality = item.quality + 1;

          if (item.name.equals(Item.BACKSTAGE_PASS)) {
            if (item.sellIn < 11) {
              if (item.quality < Item.MAX_QUALITY) {
                item.quality = item.quality + 1;
              }
            }

            if (item.sellIn < 6) {
              if (item.quality < Item.MAX_QUALITY) {
                item.quality = item.quality + 1;
              }
            }
          }
        }
      }

      if (!item.name.equals(Item.SULFURAS)) {
        item.sellIn = item.sellIn - 1;
      }

      if (item.sellIn < 0) {
        if (!item.name.equals(Item.AGED_BRIE)) {
          if (!item.name.equals(Item.BACKSTAGE_PASS)) {
            if (item.quality > 0) {
              if (!item.name.equals(Item.SULFURAS)) {
                item.quality = item.quality - 1;
              }
            }
          } else {
            item.quality = 0;
          }
        } else {
          if (item.quality < Item.MAX_QUALITY) {
            item.quality = item.quality + 1;
          }
        }
      }
    }
  }
}
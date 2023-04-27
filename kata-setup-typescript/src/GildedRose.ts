import { MAX_QUALITY } from "./constants/max-quality"
import { Item } from "./Item.js"
import { AGED_BRIE_NAME, BACKSTAGE_PASSES_NAME, SULFURAS_NAME } from "./constants/items-names.js"
export class GildedRose {
  items: Array<Item>

  constructor(items = [] as Array<Item>) {
    this.items = items
  }

  updateItemSellIn = (item: Item) => {
    if (item.name != SULFURAS_NAME) {
      item.sellIn = item.sellIn - 1
    }
  }

  updateQuality() {
    for (const item of this.items) {
      if (item.name != AGED_BRIE_NAME && item.name != BACKSTAGE_PASSES_NAME) {
        if (item.quality > 0) {
          if (item.name != SULFURAS_NAME) {
            item.quality = item.quality - 1
          }
        }
      } else {
        if (item.quality < MAX_QUALITY) {
          item.quality = item.quality + 1
          if (item.name == BACKSTAGE_PASSES_NAME) {
            if (item.sellIn < 11) {
              if (item.quality < MAX_QUALITY) {
                item.quality = item.quality + 1
              }
            }
            if (item.sellIn < 6) {
              if (item.quality < MAX_QUALITY) {
                item.quality = item.quality + 1
              }
            }
          }
        }
      }

      this.updateItemSellIn(item)

      if (item.sellIn < 0) {
        if (item.name != AGED_BRIE_NAME) {
          if (item.name != BACKSTAGE_PASSES_NAME) {
            if (item.quality > 0) {
              if (item.name != SULFURAS_NAME) {
                item.quality = item.quality - 1
              }
            }
          } else {
            item.quality = item.quality - item.quality
          }
        } else {
          if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1
          }
        }
      }
    }

    return this.items
  }
}

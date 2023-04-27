import { Item } from "./Item.js"

export class GildedRose {
  items: Array<Item>

  constructor(items = [] as Array<Item>) {
    this.items = items
  }

  private readonly MAX_QUALITY = 50

  updateQuality() {
    this.items.forEach((item) => {
      if (!this.isAgedBrie(item) && !this.isBackstage(item)) {
        if (this.haveQuality(item)) {
          if (!this.isSulfuras(item)) {
            item.quality = item.quality - 1
          }
        }
      } else {
        if (this.haveLessThanMaxQuality(item)) {
          item.quality = item.quality + 1
          if (this.isBackstage(item)) {
            if (item.sellIn < 11) {
              if (this.haveLessThanMaxQuality(item)) {
                item.quality = item.quality + 1
              }
            }
            if (item.sellIn < 6) {
              if (this.haveLessThanMaxQuality(item)) {
                item.quality = item.quality + 1
              }
            }
          }
        }
      }
      if (!this.isSulfuras(item)) {
        item.sellIn = item.sellIn - 1
      }
      if (item.sellIn < 0) {
        if (!this.isAgedBrie(item)) {
          if (!this.isBackstage(item)) {
            if (this.haveQuality(item)) {
              if (!this.isSulfuras(item)) {
                item.quality = item.quality - 1
              }
            }
          } else {
            item.quality = item.quality - item.quality
          }
        } else {
          if (this.haveLessThanMaxQuality(item)) {
            item.quality = item.quality + 1
          }
        }
      }
    })

    return this.items
  }

  private haveQuality(item: Item) {
    return item.quality > 0
  }

  private haveLessThanMaxQuality(item: Item) {
    return item.quality < this.MAX_QUALITY
  }

  private isSulfuras(item: Item) {
    return item.name == "Sulfuras, Hand of Ragnaros"
  }

  private isBackstage(item: Item) {
    return item.name == "Backstage passes to a TAFKAL80ETC concert"
  }

  private isAgedBrie(item: Item) {
    return item.name == "Aged Brie"
  }
}
